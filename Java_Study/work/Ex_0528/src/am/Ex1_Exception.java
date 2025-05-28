package am;

import java.util.Scanner;

public class Ex1_Exception {
	public static void main(String[] args) {
		
		int v1 = 100;
		Scanner sc = new Scanner(System.in);
		System.out.println("정수입력");
		int v2 = sc.nextInt();
		try {
			if(v2==0)
				return;
			int res = v1/v2;
			System.out.printf("%d/%d=%d\n",v1,v2,res);
			
		}
		catch(ArithmeticException e){
			v2 = 1;
			int res = v1/v2;
			System.out.printf("%d/%d=%d\n",v1,v2,res);
			
			
		}
		catch (Exception e) {
			// 혹시나 다른 예외가 발생할 것을 우려한 영역
			System.out.println("혹시나~");
		}finally {
			System.out.println("final");
		}
		System.out.println("out");
		
		
		sc.close();
	}
}
