package am;

public class Ex4_Array {
	public static void main(String[] args) {
//		정수 3개짜리 배열을 생성하자!
		int[] ar1 = new int[3];
		System.out.printf("%d,%d,%d\n",ar1[0],ar1[1],ar1[2]);
		
		for(int i = 0;i<ar1.length;i++)
			ar1[i]=(i+1)*10;
		
		System.out.printf("%d,%d,%d",ar1[0],ar1[1],ar1[2]);
	}
}
