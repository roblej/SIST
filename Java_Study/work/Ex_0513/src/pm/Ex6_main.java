package pm;

import java.util.Scanner;

public class Ex6_main {
	public static void main(String[] args) {		

		Ex6_Baseball bb = new Ex6_Baseball();
		
		int[] com = bb.init();
		
		System.out.println("3자리 숫자를 입력하세요");
		Scanner scan = new Scanner(System.in);
		
		do {
			bb.setCount();
			System.out.print(bb.getCount() +"차 시도:");
			String my = scan.nextLine();

			System.out.println(bb.printResult(com, bb.myAnswer(my)));

		}while(!(bb.getStrike_count()==3));
		
		System.out.println(bb.result());

		scan.close();
	}
}
