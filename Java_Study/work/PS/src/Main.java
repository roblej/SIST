import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		
		for(int i=0;i<T;i++) {
			
			int H = scan.nextInt();
			int W = scan.nextInt();
			int N = scan.nextInt();
			//H6 W12 N54 48
			int floor = N%H;
			int dong = N/H+1;
			if(floor==0) {
				floor=H;
//				dong+=;
			}
			System.out.printf("%d%d",floor*10,dong);
		}
	}
}//609다음 110나옴