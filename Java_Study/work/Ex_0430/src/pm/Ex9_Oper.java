package pm;

import java.util.Scanner;

public class Ex9_Oper {
	public static void main(String[] args) {
		//키보드로부터 정수를 하나 받아 v1으로 저장
		//v1의 값이 20대 인지? 아닌지? 판단하는 프로그램을 구현
		Scanner scan = new Scanner(System.in);
		System.out.print("v1의 값 : ");
		int a = scan.nextInt();
		boolean res = a>=20 && a<30;
		System.out.println("v1의 값은 20대인가?"+res);
	}
}
