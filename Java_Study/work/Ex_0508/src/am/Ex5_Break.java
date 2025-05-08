package am;

import java.util.Scanner;

public class Ex5_Break {

	public static void main(String[] args) {
//		문자열을 기억하는 변수  str을 선언하자!
		String str = "";
		
//		키보드와 연결된 스캐너 준비
		Scanner scan = new Scanner(System.in);
		System.out.print("문자열 입력 : ");
//		키보드로 부터 문자열을 받아서 str에 저장하자
		str = scan.nextLine();
		
		System.out.println(str);
//		사용자가 키보드로 입력한 모든 값들이 하나의 문자열로 만들어져서
//		변수 str에 저장된 상태
//		str에 있는 문자열을 한자씩 얻어내어 출력
		
		int i =0;
		char ch;
		bk1:while(i<str.length()) { //레이블 붙이기
			ch =str.charAt(i);
			System.out.printf("%c\s",ch);
//			if(ch=='0')
//				break;
			switch(ch) {
			case'0':
				System.out.println("0이네?");
				break bk1;    //레이블 지정, bk1으로 지정된 while문을 빠져나감
			case 'a':		  //레이블 미지정 시 switch문을 빠져나감
				System.out.println("a입니다");
			}
			i++;
		}
	}

}
