package am;

import java.util.Scanner;

public class Ex2_String {
	public static void main(String[] args) {
//		키보드로 문자열을 받는다.
//		그것이 숫자인지 아닌지 판단하는 프로그램을 완성하시오
		
		System.out.println("아무거나 입력하세요");
		Scanner scan = new Scanner(System.in);
		
		String str = scan.nextLine();
		char ch;
//		나의 풀이
//		boolean res = true;
//		for(int i=0;i<str.length();i++) {
//			if(!((int)(str.charAt(i))<=57&&(int)(str.charAt(i))>=48)) 
//				res = false;
//		}
//		if(res==true)
//			System.out.println("숫자입니다");
//		else
//			System.out.println("숫자가 아닙니다");
		
//		강사님 풀이
//		str에서 한 문자씩 얻어내어 그것이 0~9까지의 수들 중 하나인지?
//		아닌지 판단(boolean)하자!
		
		boolean res = true; // res가 true이면 숫자, 그렇지 않으면 문자열
		for(int i=0;i<str.length();i++) {
			ch = str.charAt(i);
//			switch(ch) {
//			case '0','1','2','3','4','5','6','7','8','9':
//				break;
//			default:
//				res = false;
//			}
			if(ch<'0'||ch>'9')
				res = false;
		}
		if(res)
			System.out.println("숫자입니다");
		else
			System.out.println("숫자가 아닙니다");
		
		
	}
}
