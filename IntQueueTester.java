package chap04;
//int형 고정길이 큐의 사용 예시

import java.util.Scanner;

public class IntQueueTester {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		IntQueue s = new IntQueue(64);
		
		while (true) {
			System.out.println(); // 구분을 위한 빈행 추가
			System.out.printf("현재 데이터 개수 : %d / %d\n", s.size(), s.getCapacity());
			System.out.print("(1) 인큐 (2) 디큐 (3) 피크 (4) 덤프 (0) 종료 : ");
			
			int menu = stdIn.nextInt();
			if (menu == 0) break;
			
			int x;
			switch (menu) {
			case 1 :
				System.out.print("데이터 : ");
				x = stdIn.nextInt();
				try {
					s.enque(x);
				} catch (IntQueue.OverflowIntQueueException e) {
					System.out.println("큐가 가득찼습니다");
				}
				break;
				
			case 2 : //가장 처음에 입력한 x가 출력되는 선입선출
				try {
					x = s.deque();
					System.out.println("디큐한 데이터는 " + x + " 입니다.");
				} catch (IntQueue.EmptyIntQueueException e) {
					System.out.println("큐가 비어있습니다.");
				}
				break;
			
			case 3 :
				try {
					x = s.peek();
					System.out.println("피크한 데이터는 " + x + "입니다.");
				} catch (IntQueue.EmptyIntQueueException e) {
					System.out.println("큐가 비어있습니다.");
				}
				break;
			
			case 4 :
				s.dump();
				break;
			}
		}
	}
}
