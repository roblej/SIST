package pm;

import java.util.Scanner;

public class Ex12_local_var {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		System.out.println("값 : ");
		int v1 = scan.nextInt();
		
		String str ="합격";
		if(v1>60) {
			//지역
//			String str ="합격";//if문 영역의 지역변수
			System.out.println(str);
		}else {
			str = "재도전";
		}
		System.out.println(str);
		
		
		
		scan.close();
	} 

}
