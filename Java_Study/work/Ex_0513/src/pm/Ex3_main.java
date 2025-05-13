package pm;

import java.util.Arrays;
import java.util.Scanner;

public class Ex3_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] res;
		
		System.out.print("단 :");
		
		Scanner scan = new Scanner(System.in);
		int dan = scan.nextInt();
		
		System.out.printf("\n%d단\n",dan);
		System.out.println("--------------");
		
		Ex3_Gugudan g = new Ex3_Gugudan();
		
		g.setDan(dan);
		res = g.post();
		
		System.out.println(Arrays.deepToString(res));
		
		for(int i=0;i<res.length;i++)
			System.out.println(res[i]);
		
		
	}

}
