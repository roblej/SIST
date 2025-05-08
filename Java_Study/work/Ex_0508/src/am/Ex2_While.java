package am;

public class Ex2_While {
	public static void main(String[] args) {
		int i = 0;
		while(i<6) {
			System.out.printf("%-4d",(int)(Math.random()*45+1));
			i++;
		}
		System.out.println();
		/*
		while문을 이용하여 다음과 같이 출력
		[결과]
		* * * *
		* * * *
		* * * *
		*/
		
		i=0;
		while(i<3) {
			int j=0;
			while(j<4) {
				System.out.printf("*\s");
				j++;
			}
			System.out.println();
			i++;
		}
	}
}
