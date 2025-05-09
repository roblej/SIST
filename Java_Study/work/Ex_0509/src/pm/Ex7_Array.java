package pm;

import java.util.Scanner;

public class Ex7_Array {

	public static void main(String[] args) {
		// TODO 각 월의 마지막 날을 저장한 배열(윤년 제외)
		
		int[] month_array = {31,29,31,30,31,30,31,31,30,31,30,31};
		
		//키보드로 월을 입력받아 해당 월이 몇일까지 있는지?
		
		Scanner scan = new Scanner(System.in);

		String cmd = "";
		do {
			//월 입력을 유도하자
			System.out.println("월 입력 : ");
			int month = scan.nextInt();//월 받기

			//숫자는 month에 들어갔지만 enter값은 아직 scanner에 남아있음
			scan.nextLine();//엔터값 처리
			System.out.printf("%-3d월은 %d일까지 입니다\n",month,month_array[month-1]);
			System.out.println("계속 하시겠습니까? y or n");
			cmd = scan.nextLine();
			
			
			
		}while(!cmd.equalsIgnoreCase("n"));// n이 아닐때 반복수행
			System.out.println("프로그램 종료!");
		
	}		

}
