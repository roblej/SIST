package pm;

import java.util.Scanner;

public class Ex4_main {
	public static void main(String[] args) {
		/*
		 프로그램이 시작되면
		 
		 선택 :
		 사번검색:1, 이름검색:2, 직책검색:3, 부서검색:4
		 1(입력)
		 검색할 사번:2022(입력)
		 
		 
		 
		 
		 */
//		프로그램 시작 이때 회사 객체 생성
		Ex4_Company com = new Ex4_Company();
//		위에서 생성한 company 객체 안에 있는 init 호출
		com.init();
		
		System.out.println("선택 :");
		System.out.println("사번검색: 1, 이름검색:2, 직책검색:3, 부서검색:4");
		
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		scan.nextLine();
		
		System.out.printf("검색할 %s:",com.which(num));
		
		String info = scan.nextLine();
		String res = com.search(info);
		
		System.out.println(res);
		
		scan.close();
	}
}
