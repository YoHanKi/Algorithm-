package chap04;
// int형 고정 길이 스택
public class IntStack {

	private int[] stk;
	private int capacity;
	private int ptr;
	
	//실행시 예외 스택이 비어있음
	public class EmptyIntStackException extends RuntimeException {
		public EmptyIntStackException() {}
	}
	//실행시 예외 : 스택이 가득 참
	public class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException() {}
	}
	
	public IntStack(int maxlen) {
		ptr = 0;
		capacity = maxlen;
		try {
			stk = new int[capacity];
		} catch (OutOfMemoryError e) {
			capacity = 0;
		}
	}
	
	// 스택에 x를 표시
	public int push(int x) throws OverflowIntStackException{
		if (ptr >= capacity)
			throw new OverflowIntStackException();
		return stk[ptr++] = x;
	}
	
	// 스택에서 데이터를 팝(탑에 있는 데이터를 꺼냄)
	public int pop() throws EmptyIntStackException {
		if (ptr <= 0)
			throw new EmptyIntStackException();
		return stk[--ptr];
	}
	// 스택에서 데이터를 피크(탑에 있는 데이터를 들여다봄)
	public int peek() throws EmptyIntStackException {
		if (ptr <= 0)
			throw new EmptyIntStackException();
		return stk[ptr -1];
	}
	// 스택을 비움
	public void clear() {
		ptr = 0;
	}
	//스택에서 x를 찾아 인덱스(없으면 -1)를 반환 / 탑쪽부터 선형 검색
	public int indexOf(int x) {
		for (int i = ptr -1 ; i >= 0; i--)
			if (stk[i] == x)
				return i;
		return -1;
	}
	//스택에 용량 반환
	public int getCapacity() {
		return capacity;
	}
	//스택에 쌓여 있는 데이터 개수를 반환
	public int size() {
		return ptr;
	}
	
	//스택이 비어있는지
	public boolean isEmpty() {
		return ptr <= 0;
	}
	//스택이 가득차있는지
	public boolean isFull() {
		return ptr >= capacity;
	}
	//스택 안의 모든 데이터를 바텀에서 탑 순서로 출력
	public void dump() {
		if (ptr <= 0)
			System.out.println("스택이 비어있습니다.");
		else {
			for (int i = 0; i < ptr ; i++)
				System.out.print(stk[i] + "");
			System.out.println();
		}
	}
}
