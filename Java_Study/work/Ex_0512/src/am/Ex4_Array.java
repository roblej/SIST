package am;

import java.util.Arrays;

public class Ex4_Array {
	public static void main(String[] args) {
		
		/*
		 0 0 0 0	1 0 0 0
		 0 0 0 0 -> 0 1 0 0
		 0 0 0 0	0 0 1 0
		 0 0 0 0	0 0 0 1
		 */
		
		int[][] ar = new int[4][4];
		
		for(int i = 0; i<ar.length;i++) {			
			for(int j =0;j<ar[i].length;j++) {	
				System.out.printf("%d\s",ar[i][j]);	
			}
			System.out.println();
		}
	
		System.out.println("===========");
		
		for(int i = 0; i<ar.length;i++) {			
			for(int j =0;j<ar[i].length;j++) {
				if(i==j) 
					ar[i][j]++;
				System.out.printf("%d\s",ar[i][j]);	
			}
			System.out.println();
		}
		
		//학생질문, 2사이즈 배열 2개를 선언하고 5사이즈 배열로 넣을 수 있나? 가능.
		int[][] ar1 = new int[2][2];
		ar1[0] = new int[5];
		
		System.out.println(Arrays.deepToString(ar1));
		
		
		
	} 
}
