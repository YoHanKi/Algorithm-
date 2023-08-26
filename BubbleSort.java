package chap06;

import java.util.Scanner;
/*버블 정렬 (드디어 배우는)
버블 정렬이란 기포가 마치 아래에서 위로 올라오듯 정렬을 한 방향에서 비교하며 이동하여 정렬하는 방식*/
public class BubbleSort {
 
	// a[idx1]과 a[idx2]의 값을 교환
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}
	
	//버블 정렬
	static void bubbleSort(int[] a, int n) {
		for (int i = 0; i < n-1 ; i++)
			for (int j = n-1 ; j > i ; j--)
				if (a[j-1] > a[j])
					swap(a, j=1, j);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("버블정렬(ver.1)");
		System.out.print("요솟수 : ");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];
		
		for (int i = 0; i < nx; i++) {
			System.out.print("x["+i+"]: ");
			x[i] = stdIn.nextInt();
		}
		
		bubbleSort(x, nx);
		
		System.out.println("오름차순으로 정렬");
		for(int i = 0; i < nx; i++)
			System.out.println("x[" + i + "]=" + x[i]);
	}

}
