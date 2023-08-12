package chap02;
//1000 이하의 소수를 나열
public class PrimeNumber {

	public static void main(String[] args) {
		int counter = 0; //나눗셈 횟수
		int ptr = 0;     //찾은 소수의 갯수
		int[] prime = new int[500];  //소수를 저장하는 배열
		
		prime[ptr++] = 2;
		prime[ptr++] = 3;
		
		for ( int n = 5 ; n <= 1000 ; n+=2) {
			boolean flag = false;
			int i;
			for (i = 1; prime[i]*prime[i] <= n ; i++) {
				counter+=2;
				if (n % prime[i] == 0)
					flag = true;
					break;
			}
			if (!flag) {
				prime[ptr++] = n;
				counter++;
			}
		}

		for ( int i = 0; i < ptr ; i++)
			System.out.println(prime[i]);
		
		System.out.println("곱셈과 나눗셈 횟수 : "+ counter);
	}

}
