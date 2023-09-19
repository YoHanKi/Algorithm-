package chap10;

public class ChainHash<K,V> {
	
	//해쉬를 구성하는 노드
	class Node<K,V> {
		private K key;
		private V data;
		private Node<K,V> next;	//다음노드에 대한 참조
		
		//생성자
		Node(K key, V data, Node<K,V> next) {
			this.key = key;
			this.data = data;
			this.next = next;
		}
		
		//키값 반환
		K getKey() {
			return key;
		}
		
		//데이터 반환
		V getValue() {
			return data;
		}
		
		//키 해쉬값을 반환
		public int hashCode() {
			return key.hashCode();
		}
	}
	
	private int size;
	private Node<K,V>[] table;
	
	//생성자
	public ChainHash(int capacity) {
		try {
			table = new Node[capacity];
			this.size = capacity;
		} catch (OutOfMemoryError e) {
			this.size = 0;
		}
	}
	
	//해쉬값을 구함
	public int hashValue(Object key) {
		return key.hashCode() % size;
	}
	
	//키값이 key인 요소를 검색(데이터 반환)
	public V search(K key) {
		int hash = hashValue(key);
		Node<K,V> p = table[hash];
		
		while ( p != null) {
			if (p.getKey().equals(key))
				return p.getValue();
			p = p.next;
		}
		return null;
	}
	
	//키값이 key이고 데이터가 data인 요소를 추가
	public int add(K key, V data) {
		int hash = hashValue(key);
		Node<K,V> p = table[hash];
		
		while (p != null) {
			if (p.getKey().equals(key))
				return 1;
			p = p.next;
		}
		Node<K,V> temp = new Node<K,V>(key, data, table[hash]);
		table[hash] = temp;
		return 0;
	}
	
	//키값이 key인 요소를 삭제
	public int remove(K key) {
		int hash = hashValue(key);
		Node<K,V> p = table[hash];
		Node<K,V> pp = null;
		
		while (p != null) {
			if (p.getKey().equals(key)) {
				if (pp == null)
					table[hash] = p.next;
				else
					pp.next = p.next;
				return 0;
			}
			pp = p;
			p = p.next;
		}
		return 1;
	}
	
	//해시 테이블을 덤프
	public void dump() {
		for (int i = 0; i < size; i++) {
			Node<K,V> p = table[i];
			System.out.printf("%02d  ", i);
			while (p != null) {
				System.out.printf(" -> %s (%s)  ", p.getKey(), p.getValue());
				p= p.next;
			}
			System.out.println();
		}
	}
}
