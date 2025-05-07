package pm;

public class Ex11_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		배열은 같은 자료형 여러 개를 하나로 묶은 것
//		1차원 배열
//		정수 6개를 저장할 수 있는 배열 준비
//		int ar[]= new int[6];
		int[] ar = new int[6];
		for(int i=0;i<6;i++) {
			ar[i]=(int) (Math.random()*45+1);
			System.out.printf("%d\s",ar[i]);							
		}
			
	}	
}
