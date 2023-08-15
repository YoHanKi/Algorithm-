package chap03;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

class PhysExamSearch {
// 제네릭 binarySearch 메서드를 사용하여 이진 검색
	static class PhyscData {
		private String name;	
		private int height;
		private double vision;
	
	public PhyscData(String name, int height, double vision) {
		this.name = name; this.height = height; this.vision = vision;
	}
	//찾은 값을 문자열로 반환하는 메소드
	public String toString() {
		return name + " " + height + " " + vision;
	}
	//height의 오름차순으로 반환하는 메소드
	public static final Comparator<PhyscData> HEIGHT_ORDER = new HeightOrderComparator();
	
	private static class HeightOrderComparator implements Comparator<PhyscData> {
		public int compare(PhyscData d1, PhyscData d2) {
			return (d1.height > d2.height) ? 1 :
				(d1.height < d2.height) ? -1 : 0 ;
		}
	}
}
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		PhyscData[] x = {
				new PhyscData("민지", 162, 0.3),
				new PhyscData("하니", 168, 0.4),
				new PhyscData("아이유", 166, 0.8),
				new PhyscData("채령", 164, 1.0),
				new PhyscData("도도새", 170, 0.7),
		};
		System.out.print("키가 몇센지 인사람은 찾는지 : ");
		int height = stdIn.nextInt();
		int idx = Arrays.binarySearch(x, new PhyscData("", height, 0.0), PhyscData.HEIGHT_ORDER);
		
		if(idx < 0) System.out.println("해당하는 값의 요소가 없습니다");
		else { System.out.println("해당하는 값은 x[" + idx + "]에 있습니다.");
				System.out.println("찾는 데이터 값 : " + x[idx]);
		}
	}
}

