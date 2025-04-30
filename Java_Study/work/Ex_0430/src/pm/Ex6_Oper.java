package pm;

import java.util.Scanner;

public class Ex6_Oper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10;
		Scanner scan = new Scanner(System.in);
		System.out.print("값: ");
		a = scan.nextInt();//키보드로부터 정수 하나를 받기위해 대기
		System.out.println(a < 10);
		System.out.print("값: ");
		int b = scan.nextInt();//키보드로부터 정수 하나를 받기위해 대기
		System.out.println(a!=b); // a와 b가 같지 않을때 true
		System.out.println(a==b); // a와 b가 같을때 true
		
		
		

		
	}

}
