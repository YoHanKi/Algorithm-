package chap06;

import java.util.Scanner;

public class Partition {
	// 배열 요소 a[idx1]과 a[idx2]의 값을 교환
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}
	
	//배열을 나눔
	static void partition(int[] a, int n) {
		int pl = 0;
		int pr = n-1;
		int x = a[n/2];
		
		do {
			while (a[pl] < x) pl++;
			while (a[pr] > x) pr--;
			if (pl <= pr)
				swap(a, pl++, pl--);
		} while (pl <= pr);
	

	System.out.println("피벗값은" + x + "입니다.");
	
	System.out.println("피벗 이하의 그룹");
	for (int i = 0 ; i <= pl -1 ; i++)
		System.out.print(a[i] + " ");
	System.out.println();
	
	if (pl > pr+1) {
		System.out.println("피벗과 같은 그룹");
		for (int i = pr + 1; i <= pl ; i++)
			System.out.print(a[i] + "");
		System.out.println();
	}
	}	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("배열을 나눕니다");
		System.out.print("요솟수 : ");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];
		
		for (int i = 0; i <nx ; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = stdIn.nextInt();
		}
		partition(x,nx);
	}
}
