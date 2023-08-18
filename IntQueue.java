package chap04;
//링 버퍼를 사용한 큐
public class IntQueue {
	private int[] que;
	private int capacity;
	private int front;
	private int rear;
	private int num;

	//실행시 예외 스택이 비어있음
	public class EmptyIntQueueException extends RuntimeException {
		public EmptyIntQueueException() {}
	}
	//실행시 예외 : 스택이 가득 참
	public class OverflowIntQueueException extends RuntimeException {
		public OverflowIntQueueException() {}
	}
	
	public IntQueue(int maxlen) {
		num = front = rear = 0;
		capacity = maxlen;
		try {
			que = new int[capacity];
		} catch(OutOfMemoryError e) {
			capacity = 0;
		}
	}
	//큐에 데이터를 인큐(축적)
	public int enque(int x) throws OverflowIntQueueException {
		if (num >= capacity)
			throw new OverflowIntQueueException();
		que[rear++] = x;
		num++;
		if (rear == capacity)
			rear = 0;
		return x;
	}
	public int deque() throws EmptyIntQueueException{
		if(num <= 0)
			throw new EmptyIntQueueException();
		int x = que[front++];
		num--;
		if ( front == capacity) front = 0;
		return x;	
	}
	public int peek() throws EmptyIntQueueException {
		if (num <= 0) throw new EmptyIntQueueException();
		return que[front];
	}
	
	public void clear() {
		num = front = rear = 0;
	}
	public int indexOf(int x) {
		for (int i = 0; i < num ; i++) {
			int idx = (i + front) % capacity;
			if(que[idx] == x) return idx;
		}
		return -1;
	}
	
	//스택에 용량 반환
		public int getCapacity() {
			return capacity;
		}
		//스택에 쌓여 있는 데이터 개수를 반환
		public int size() {
			return num;
		}
		
		//스택이 비어있는지
		public boolean isEmpty() {
			return num <= 0;
		}
		//스택이 가득차있는지
		public boolean isFull() {
			return num >= capacity;
		}
		//스택 안의 모든 데이터를 바텀에서 탑 순서로 출력
		public void dump() {
			if (num <= 0)
				System.out.println("스택이 비어있습니다.");
			else {
				for (int i = 0; i < num ; i++)
					System.out.print(que[(i + front) % capacity] + " ");
				System.out.println();
			}
		}
}