package pm;

import java.util.Arrays;

public class Ex5_Array {
	public static void main(String[] args) {
		int[] ar1 = {10,20,30,40};
		int[] ar2 =new int[3];
		int[] ar3 =new int[5];
		
		int[][] ar4 = new int[3][];
		ar4[0]= ar1;
		ar4[1]= ar2;
		ar4[2]= ar3;
		
		System.out.println(Arrays.deepToString(ar4));
		
		
		
	}
}
