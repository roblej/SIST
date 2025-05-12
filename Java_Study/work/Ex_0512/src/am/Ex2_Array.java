package am;

public class Ex2_Array {
	public static void main(String[] args) {
//		2차원 배열을 생성하자!
		int[][] ar = new int[3][3];
		int num = 0;
		for(int i=0;i<ar.length; i++) { //2차원배열의 길이를 반복 수행(행)
			for(int j=0;j<ar[i].length;j++) {
				ar[i][j]=++num;
				//각 1차원 배열을 반복하는 반복문
				System.out.printf("%-2d",ar[i][j]);
			}
			System.out.println();//줄바꿈: 1차원 배열이 끝날때 마다
		}
	}
}
