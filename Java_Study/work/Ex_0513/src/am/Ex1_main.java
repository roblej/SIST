package am;

import java.util.Scanner;

public class Ex1_main {
	public static void main(String[] args) {
		
		System.out.print("입력: ");
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		
		Ex1_Color c1 = new Ex1_Color(); // 객체 생성
		
		c1.setColor(str);//c1의 color값을 str값으로 변경
		String str1 =c1.getColor();
		
		System.out.println(str1); 
	}
}
