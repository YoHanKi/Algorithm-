package chap02;

import java.util.Scanner;

public class CardConv {
//정수값 x를 r정수로 변환하여 배열 d에 아랫자리로부터 넣어 두고 자릿수를 반환
	static int cardConv(int x, int r, char[] d) {
		int digits = 0;
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		do {
			d[digits++] = dchar.charAt(x % r);
			x /= r;
		} while (x != 0);
		
		for (int i = 0; i < digits / 2; i++) {
			char t = d[i];
			d[i] = d[digits - i - 1];
			d[digits - i - 1] = t;
		}
		return digits;
	}
		public static void main(String[] args) {
			Scanner stdIn = new Scanner(System.in);
			int no; //변환 정수
			int cd; //기수
			int dno; //변환 후 자릿 수
			
			char[] cno = new char[32];
			
			System.out.println("10진수를 기수 변환합니다.");
			
				do {
					System.out.print("변환하는 음이 아닌 정수 : ");
					no = stdIn.nextInt();
				} while (no < 0);
				do { 
					System.out.print("변환을 원하는 진수(2~36) : ");
					cd = stdIn.nextInt();
				} while (cd <2 || cd > 36);
				
				dno = cardConv(no, cd, cno);
				
				System.out.print(cd + "진수로");
				for ( int i = 0 ; i < dno ; i++)
					System.out.print(cno[i]);
					System.out.println("입니다.");
			}
		}	
		
		



