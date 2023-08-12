package chap02;

import java.util.Scanner;
import java.util.Arrays;

public class ReverseArray {

//배열 요소 a[idx1]과 a[idx2]의 위치를 변경
	static void swap(int[]a, int idx1, int idx2) {
		int t = a[idx1]; a[idx1] = a[idx2]; a[idx2] = t ;
	}
//배열 a의 요소를 역순으로 정렬
	static void reverse(int[]a) {
		for (int i = 0 ; i < a.length / 2 ; i++)
			swap(a,i,a.length - i -1); //배열의 i번째와 i와 마주보는 뒷 순서를 변경
	}
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("요솟수 : ");
		int num = stdIn.nextInt();
		
		int[] x = new int[num];
		
		for(int i = 0 ; i < num ; i++) {
			System.out.print("x[" + i + "] = ");
			x[i] = stdIn.nextInt();
		}

		reverse(x); // 배열 a의 요소를 역순으로 정렬
		
		System.out.println("x = " + Arrays.toString(x));
	}
}
