package pm;

import java.util.Scanner;

public class Ex7_Oper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//키보드로 부터 정수를 받기 위해 필요한 객체
		Scanner scan = new Scanner(System.in);
		//정수를 받기 전에 문자열 출력으로 표현
		System.out.print("정수입력 : ");
		
		//키보드에 연결된 스캐너로부터 정수를 하나 받아서
		//변수 v1에 저장
		int v1 = scan.nextInt();
//		System.out.println(v1);
//		if(v1<=19) System.out.println(true);
//		else if(10<=v1) System.out.println(true);
//		else System.out.println(false);
		boolean res = (10<=v1)&&(v1<=19);
		//and연산 좌측 연산이 false일때 우측 연산 수행하지않음
		System.out.println("Q:v1의 값이 10대인가? \nA:"+res);
		
		
	}

}
