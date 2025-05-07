package am;

import java.util.Scanner;

public class Ex8_For {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//문제1. 키보드로부터 숫자를 하나 받아서 변수에 v1에 저장한 후 
		//1부터 v1인 만큼 반복하여 합을 구하는 프로그램 구현
		
		Scanner scan = new Scanner(System.in);
		int sum = 0;
		System.out.print("입력할 숫자 : ");
		int v1 = scan.nextInt();
		for(int i = 1;i<=v1;i++) {
			sum+=i;
		}
		System.out.println("1부터 "+v1+"까지의 수의 합"+sum);
		
		System.out.println("---------------------");
		
		
		//문제 2 10~50까지의 수들 중 난수를 하나 발생하여
		//변수 su에 저장한 후 1부터 su인 만큼 반복하여 합을 구하시오
		
		int su = (int)(Math.random()*41+10);
		sum = 0;
		System.out.println("랜덤10~50의 수 : "+su);
		for(int i=1;i<=su;i++) {
			sum+=i;
		}
		System.out.println("1부터 "+su+"까지의 수의 합"+sum);
		
		scan.close();
	}

}
