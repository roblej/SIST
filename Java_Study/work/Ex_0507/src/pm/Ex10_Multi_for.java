package pm;

public class Ex10_Multi_for {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 4;
		for(int i = 0; i<3;i++) {
			for(int j = 1;j<=num;j++) {
					System.out.printf("%d\s",j+i*num);
			}
			System.out.println();
		}
		System.out.println("-----------------");
		
		int num2 = 0;
		for(int i = 0; i<2;i++) {
			for(int j = 1;j<=num;j++) {
					System.out.printf("%d\s",++num2);
			}
			System.out.println();
		}
		System.out.println("-----------------");
		/*
		 * [결과]
		 * * * *
		 * * * *
		 * * * *
		 * * * *
		 */
		for(int i = 0;i<4;i++) {
			for(int j=0;j<4;j++) {
				System.out.printf("%s\s","*");
			}
			System.out.println();
		}
		System.out.println("-----------------");
		/*
		 결과2
		 0 * * *
		 * 0 * *
		 * * 0 *
		 * * * 0
		 */
		for(int i = 0;i<4;i++) {
			for(int j=0;j<4;j++) {
				if(j==i) {
					System.out.printf("%c\s",'0');
				}else {
					System.out.printf("%c\s",'*');
				}
			}
			System.out.println();
		}
	}

}
