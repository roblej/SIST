package pm;

public class Ex9_Multi_For {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 화면에 1~5까지 출력하는 반복문
		for(int j=1;j<=3;j++) {
			for(int i =1;i<=5;i++) {
	//			System.out.print(i+" ");
				System.out.printf("%d\s",i);
	//			System.out.printf("%-2d",i);
			}
			System.out.println();
		}
		
		for(int j=0;j<5;j++) {			
			for(int i=1;i<=5-j;i++) {
				System.out.printf("*\s");
	//			System.out.printf("%2s",'*');
			}
			System.out.println();
		}
	}
}
