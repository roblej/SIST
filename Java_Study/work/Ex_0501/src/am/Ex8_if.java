package am;

import java.util.Scanner;

public class Ex8_if {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		
		if((a>19)&&(a<30)) {
			System.out.println("a는 20대 입니다.");
		}else {
			System.out.println("a는 20대가 아닙니다.");			
		}
		
	}

}
