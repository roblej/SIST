package pm;

import java.util.Scanner;

public class Ex5_main {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("단 :");
		int dan = scan.nextInt();
		
		Ex5_Gugudan g1 = new Ex5_Gugudan();
		g1.setDan(dan);
		
		String res = g1.result();
		
		System.out.println(res.replace("*", "x"));
		
	}
}
