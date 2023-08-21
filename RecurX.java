package chap05;

import java.util.Scanner;
//int형 스택을 이용한 비재귀적 함수
public class RecurX {
	//재귀를 제거
	static void recur(int n) {
		IntStack s = new IntStack(n);
		
		while (true) {
			if (n > 0) {
				s.push(n);
				n= n-1;
				continue;
			}
			if (s.isEmpty() != true) { //비어있지 않다면
				n = s.pop();
				System.out.println(n);
				n=n-2;
				continue;
			}
			break;
		}
	}
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요 :");
		int x = stdIn.nextInt();
		
		recur(x);

	}

}
