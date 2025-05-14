package pm;

import java.util.Scanner;

public class Ex6_main {
	public static void main(String[] args) {		

		Ex6_Baseball bb = new Ex6_Baseball();
		
		bb.init();
		
		System.out.println("3자리 숫자를 입력하세요");
		Scanner scan = new Scanner(System.in);
		
		do {
			bb.setCount();
			bb.resetBallStr();
			
			System.out.print(bb.getCount() +"차 시도:");
			String my = scan.nextLine();
			if(my.length()>3) {
				System.out.println("3자만 입력하세요.");
				continue;
			}
			bb.myAnswer(my);
			
			System.out.println(bb.getBallStr());

		}while(bb.getStrike_count()!=3);
		
		System.out.println(bb.result());

		scan.close();
	}
}
