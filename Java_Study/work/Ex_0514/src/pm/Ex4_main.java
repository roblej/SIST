package pm;

import java.util.Arrays;
import java.util.Scanner;

public class Ex4_main {
/*
 프로그램 시작, insert coin 메세지 출력.
 700 enter -> 700원으로 선택할 수 있는 음료수 이름들이 출력->> nextInt형으로 받자
 음료 목록
 레쓰비 : 500원
 사이다 : 700원
 콜라 : 700원
 웰치스 : 1000원
 
 1.레쓰비 2.사이다 3.콜라 선택: //1,2,3중에 선택
 if choose 2)
 사이다를 선택하셨습니다.
 잔돈 0원 입니다.
 */
	
	public static void main(String[] args) {
		System.out.print("Insert Coin :");
		Scanner scan = new Scanner(System.in);
		
		Ex4_ven v1 = new Ex4_ven();
		v1.setAr();
		
		int coin = scan.nextInt();
		
//		String[] res = v1.insert1(coin);
//		System.out.print(Arrays.toString(res)+" 선택 :");
		
		String res = v1.insert(coin);
		System.out.print(res+" 선택 :");
		
		int choice = scan.nextInt();
		
		int enough = v1.choice(choice);
//		int enough = v1.choice1(choice);
		System.out.println(v1.ar[choice-1].getD_name()+"를 선택하셨습니다.");
		System.out.println("잔돈" + enough + "원 입니다.");
		
		scan.close();
	}
}
