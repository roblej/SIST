package am;

import java.util.Scanner;

public class Ex9_if {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("0~100 사이의 점수를 입력해주세요");
		int score = scan.nextInt();

//		while (score > 100 || score < 0) {
//			System.out.println("유효하지 않은 값입니다. 다시 입력해주세요");
//			score = scan.nextInt();
//		}
//		
//		if (score >= 60) {
//			System.out.println("합격");
//		} else {
//			System.out.println("불합격");
//		}
//
//		scan.close();

		if(score>0&&score<=100) {
			if(score>=60) {
				System.out.println("합격");
			}else System.out.println("불합격");
		}else System.out.println("유효하지 않은 값입니다.");

		if (score>100) {
			System.out.println();
			return; // 제어권 반환(호출한 곳으로 돌아간다.
		}
		int a =test();
		System.out.println(a);
		 
		 
	}
	public static int test() {
		System.out.println("Hello World!");
		return 1;
	}
}
