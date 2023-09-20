package chap10;

public class OpenHash<K,V> {
	
	//버킷의 상태
	enum Status {OCCUPIED, EMPTY, DELETED};	//상태 열거형(저장, 비어있음, 삭제)
	
	//버킷
	static class Bucket<K,V> {
		private K key;
		private V data;
		private Status stat;
		
		//생성자
		Bucket() {
			stat = Status.EMPTY;	//비어있음
		}
		
		//모든필드에 값을 설정
		void set(K key, V data, Status stat) {
			this.key = key;
			this.data = data;
			this.stat = stat;
		}
		
		//상태를 설정
		void setStat(Status stat) {
			this.stat = stat;
		}
		
		//키값을 반환
		K getKey() {
			return key;
		}
		
		//데이터 반환
		V getValue() {
			return data;
		}
		
		//키의 해시값을 반환
		public int hashCode() {
			return key.hashCode();
		}
	}
	
	private int size;
	private Bucket<K,V>[] table;
	
	//생성자
	public OpenHash(int size ) {
		try {
			table = new Bucket[size];
			for (int i = 0; i < size; i++)
				table[i] = new Bucket<K,V>();
			this.size = size;
		} catch (OutOfMemoryError e) {
			this.size = 0;
		}
	}
	
	//해시값 구함
	public int hashValue(Object key) {
		return key.hashCode() % size;
	}
	
	//재해시값을 구함
	public int rehashValue(int hash) {
		return (hash + 1) % size;
	}
	
	//키값이 key인 버킷을 검색
	private Bucket<K,V> searchNode(K key) {
		int hash = hashValue(key);
		Bucket<K,V> p = table[hash];
		
		for (int i = 0; p.stat != Status.EMPTY && i < size; i++) {
			if (p.stat == Status.OCCUPIED && p.getKey().equals(key))
				return p;
			hash = rehashValue(hash);
			p = table[hash];
		}
		return null;
	}
	
	//키값이 key인 요소를 검색
	public V search(K key) {
		Bucket<K,V> p = searchNode(key);
		if (p != null)
			return p.getValue();
		else
			return null;
	}
	
	//키값이 key 이고 데이터가 data인 요소 추가
	public int add(K key, V data) {
		if (search(key) != null)
			return 1;
		
		int hash = hashValue(key);
		Bucket<K,V> p = table[hash];
		for (int i = 0; i < size; i ++) {
			if (p.stat == Status.EMPTY || p.stat == Status.DELETED) {
				p.set(key,  data, Status.OCCUPIED);
				return 0;
			}
			hash = rehashValue(hash);
			p = table[hash];
		}
		return 2;
	}
	
	//키값이 key인 요소 삭제
	public int remove(K key) {
		Bucket<K,V> p = searchNode(key);
		if (p == null)
			return 1;
		
		p.setStat(Status.DELETED);
		return 0;
	}
	
	//해시 테이블을 덤프
	public void dump() {
		for (int i = 0; i < size; i++) {
			System.out.printf("%02d ", i);
			switch (table[i].stat) {
			case OCCUPIED :
				System.out.printf("%s (%s)\n", table[i].getKey(), table[i].getValue());
				break;
				
			case EMPTY :
				System.out.println("--비어있음"); break;
				
			case DELETED :
				System.out.println("--삭제 마침--"); break;
			}
		}
	}
}
