package am;

public class Ex3_Break {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 		[결과]
 		1 2 3 4
 		1 2 3 4
 */		
		int i = 0;
		while(i<2){
			int j=1;
			while(j<=4) {
				System.out.printf("%-2d",j++);
				if(j%3==0) break;
			}
			System.out.println();
			i++;
		}
	}

}
