package chap05;
//분기한정법
//각행과 열에 퀸 1개를 배치하는 조합을 재귀적으로 나열
public class queenBB {
	static boolean[] flag = new boolean[8];
	static int[] pos = new int[8];
	
	//각 열에 있는 퀸의 위치를 출력
		static void print() {
			for (int i = 0 ; i < 8 ; i++)
				System.out.printf("%2d", pos[i]);
			System.out.println();
		}
		//i열에 알맞는 퀸을 배치
		static void set(int i) {
			for (int j = 0; j < 8; j++) {
				if(flag[j] == false) {
				pos[i] = j;
				if (i == 7)
					print();
				else {
					flag[j] = true;
					set(i + 1);
					flag[j] = false;
				}
			}
		}
	}
		
	public static void main(String[] args) {
		set(0);

	}

}
