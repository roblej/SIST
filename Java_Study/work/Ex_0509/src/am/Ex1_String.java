package am;

import java.util.Scanner;

public class Ex1_String {
	public static void main(String[] args) {
//		물류센터에서에서 각 제품의 제품번호를 읽어온다.
//		이 상황을 키보드로 입력받는것으로 하자!
		System.out.print("제품번호를 입력하세요 :");
		
		Scanner scan = new Scanner(System.in);
//		제품번호 형식 : 제조날짜-카테고리-유형코드
//						250509-E-120
		String num = scan.nextLine();
		
//		입력된 제품번호의 8번째 자리의 문자를 얻어내어
//		그것이 'L'이면 "생활용품",'E'면 "가전제품",'S'면 "스포츠용품"
//		으로 구분하도록 하기
		int size = num.length();
		if(size<8) {
			System.out.println("잘못된 제품번호입니다.");
			return;
		}
//		while(size<8) {
//			System.out.println("잘못된 제품번호입니다.다시 입력하세요");
//			num = scan.nextLine();
//			size = num.length();
//		}
		
		char ch = num.charAt(7);
		switch(ch) {
		case 'S':
			System.out.println("스포츠제품");
			break;
		case 'L':
			System.out.println("생활용품");
			break;
		case 'E':
			System.out.println("가전제품");
			break;
		}
	}
}
