package am;

public class Ex3_Array {
	public static void main(String[] args) {
		
//		정수형 2차원 배열 생성
		int[][] ar = new int[3][4];//길이가 4개짜리 1차원 배열 3개를 저장하는 2차원배열
		int num =10;
		
		for(int i=0;i<ar.length;i++) {
			for(int j=0;j<ar[i].length;j++) {
				ar[i][j]=++num;
				System.out.printf("%2d\s",ar[i][j]);
			}
			System.out.println();
		}
		System.out.println("===========");
		
		
	}
}
