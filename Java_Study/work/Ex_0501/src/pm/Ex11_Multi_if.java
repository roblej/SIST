package pm;

import java.util.Scanner;

public class Ex11_Multi_if {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("값 : ");
		Scanner scan = new Scanner(System.in);
		int value = scan.nextInt();
		
		//변수 value의 값이 1 or 2 or 3이 들어간다고 가정
		//1일때, "초급" 2일때,"중급", 3일때,"고급" 출력, 다중if문으로 구현
		
//    		if(value == 1 || value == 2 || value == 3) {
//			
//			if(value == 1) System.out.println("초급");
//			else if(value == 2) System.out.println("중급");
//			else System.out.println("고수");
//			
//		}else {
//			System.out.println("잘못 입력");
//		}
		
//		if(value == 1)
//			System.out.println("초급");
//		else if(value == 2)
//			System.out.println("중급");
//		else if(value == 3)
//			System.out.println("고급");
//		else
//			System.out.println("잘못 입력");
		String str = "";
		
		if(value == 1)
			str = "초급";
		else if(value == 2)
			str = "중급";
		else if(value == 3)
			str = "고급";
		else
			str = "잘못 입력";
		
		System.out.println(str);
		
		scan.close();	
	}

}

