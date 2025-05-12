package am;

import java.util.Arrays;

public class Ex1_Array {
	public static void main(String[] args) {
		String[] ar3 = new String[3];
		ar3[0]="100";
		ar3[1]="200";
		ar3[2]="300";
		
		System.out.println(Arrays.toString(ar3));
		
		String[] ar4 = new String[3];
		ar4[0]=ar3[0];
		ar4[1]="100";
		
		System.out.println(ar3[0]==ar4[0]);
		System.out.println(ar3[0]==ar4[1]);
		System.out.println(ar4[0]==ar4[1]);
		
		ar4[2]=new String("100");
		System.out.println(ar4[0]==ar4[2]);
		
		System.out.println("===========================");
		
		String str ="쌍용교육센터:3강의장:오경주";
		//str에 저장된 문자열에서 ":"을 중심으로 분할처리하여 배열로 반환
		String[] ar12=str.split(":");
		System.out.println(Arrays.toString(ar12));
		
		System.out.println("===========================");
		//다차원배열
		
		int ar[]=new int[3];
		int ar1[] = new int[3];
		int[][] a = new int[2][3]; //앞의[2]<<저장할 1차원배열의 갯수, 뒤[3]<<저장될 각 1차원배열의 길이
		a[0]= ar;
		a[1]=ar;
		 System.out.println(Arrays.deepToString(a));
		
		
	}
}
