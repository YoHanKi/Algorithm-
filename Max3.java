package chap01;

public class Max3 {
	//abc의 최댓값을 구하여 반환
	static int max3(int a, int b, int c) {
		int max = a;
		if(b > max) max = b;
		if(c > max) max = c;
		
		return max;
	}
	
public static void main(String [] args) {
	System.out.println("max3(3,2,1)= " + max3(3,2,1));
}
}
