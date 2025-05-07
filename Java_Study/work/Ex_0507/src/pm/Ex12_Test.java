package pm;

public class Ex12_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 문제1)다음의 결과와 같은 모양을 출력하는 반복문을 구현
		 [결과]
		 * * * *
		 * * * 
		 * *
		 * 
 
		 */
		for(int j=0;j<4;j++) {			
			for(int i=1;i<=4-j;i++) {
				System.out.printf("*\s");
			}
			System.out.println();
		}
		System.out.println("================");
		/*
		 문제2)다음의 결과와 같은 모양을 출력하는 반복문을 구현
		 [결과]
		 * * * *
		   * * * 
		     * *
		       *

		 */
		for(int i=0;i<4;i++) {
			for(int j=4;j>0;j--) {
				if(j==4) {
				}else
					System.out.print("  ");
				if(i+j==4)
					break;
				}
			for(int k=4;k-i>0;k--){				
				System.out.print("* ");
			}
			System.out.println();
			}
		
		System.out.println("================");
		/*
		 문제3)구구단을 다음과 같이 출력하는 반복문을 구현
		 [결과]
		 2*1=2   3*1=3   ... 9*1= 9
		 2*2=4   3*2=6   ... 9*2 = 18
		 ...     ...     ...
		 2*9=18  3*9=27  ... 9*9 = 81
		 */
		for(int i=1;i<=9;i++) {
			for(int j=2;j<=9;j++) {
				System.out.printf("%d*%d=%d ",j,i,i*j);
			}
			System.out.println();
		}
	}

}
