package pm;

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
		
		String[] res = v1.insert(coin);
		for(int i=0;i<res.length;i++) {
			if(res[i]!=null) {
				System.out.printf("%d\s",i+1);
				System.out.printf("%s\s",res[i]);
			}
		}
		System.out.printf("\t선택 :");
		
		int choice = scan.nextInt();
		
//		int change = v1.choice(choice);
//		System.out.println(res[choice-1]+"를 선택하셨습니다.");
//		System.out.println("잔돈" + change + "원 입니다.");
		
		Ex4_drink d= v1.getDrink(choice);
		System.out.printf("선택한 음료는 :%s, 잔돈:%d원 입니다. ",
				d.getD_name(),coin - d.getPrice());
		
		scan.close();
	}
}
