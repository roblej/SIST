package pm;

import java.util.Arrays;

public class Ex6_Array {
	public static void main(String[] args) {
		String[] a1 = new String[4];
		
		a1[0] ="값1";
		a1[1] = new String("값1");
		a1[2] = new String("값3");
		a1[3] = "값4";
		
		String[] a2 = {"val1","val2","val3","val4"};
		
//		a1과 a2라는 1차원 배열을 한곳에 모아두는 2차원 배열을 만들자
		String[][] ar = new String[2][4];
		
//		준비된 2차원배열 각 요소에 a1과 a2를 저장
		ar[0] = a1;
		ar[1] = a2;
		
//		이제 다시 2차원 배열 생성 초기값 들을
//		다음 과 같이 하고자 한다면 선ㅇ너,생성,초기화를 한번에
		/*
		 v1 v2 v3 v4
		 n1 n2 n3 n4
		 */
		String[][] ar2 = {
				{"v1","v2","v3","v4"},
				{"n1","n2","n3","n4"}
		};
		
		String[][][] ar3 = new String[2][4][4];
		ar3[0]=ar;
		ar3[1]=ar2;
		
//		System.out.println(Arrays.deepToString(ar3));
		
		for(int i=0;i<ar3.length;i++) { //3차원 배열에 저장된 2차원 배열을 반복할 for
			for(int j=0;j<ar3[i].length;j++) { //2차원 배열에 저장된 1차원 배열 for
				for(int k=0;k<ar3[i][j].length;k++) {//1차원 배열에 저장된 값을 반복
					System.out.printf("=>%-3s\s",ar3[i][j][k]);
				}
				System.out.println();
				
			}
		}
	
		//2차원배열
		/*
		 다이아 금두꺼비 꽝 로또1등
		 꽝	    황금알 비누	  아파트
		 꽝      천원    꽝  거품  
		 */
		String[][] ran = {
				{"다이아","금두꺼비","꽝","로또1등",},
				{"꽝","황금알","비누","아파트",},
				{"꽝","천원","꽝","거품"}
		};
		
		for(int i=0;i<ran.length;i++) {
			for(int j=0;j<ran[i].length;j++) {
				System.out.printf("%-15s",ran[i][j]);
			}
			System.out.println();
		}
		
		int i,j;
		i=(int) (Math.random()*ran.length);
		j=(int)(Math.random()*ran[i].length);
		System.out.println(ran[i][j]);
	}
}
