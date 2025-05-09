package pm;

import java.util.Arrays;
import java.util.Collections;

public class Ex6_Array {

	public static void main(String[] args) {
		// 프로그램 시작
		
//		정수 5개를 저장하는 배열을 만들자!
		int[] ar = new int[5];
		
//		 외부로부터 배열의 값을 받았다고 가정하자!
		ar[0] = 1;
		ar[1] = 36;
		ar[2] = 12;
		ar[3] = 25;
		ar[4] = 21;
		
//		정렬을 시키기 위해 java.util.Arrays객체가 필요함! 위는
//		Arrays.sort(ar); //오름차순 - 1만건 이하면 이게 나쁘지 않다.
		Arrays.parallelSort(ar);//배열이 크고(10만 이상 또는 천만 이상)
//		그 안에 있는 값들이 들쑥날쑥인 경우 parallelSort가 빠르고
//		배열의 크기가 작고 정렬이 된 경우는 sort가 빠르다
		
		for(int i=0;i<ar.length;i++) {
			System.out.printf("%-3d",ar[i]);
		}
		System.out.println("\n======================");
//		내림차순을 정렬시키기 위해서는 java.util.Collections가 필요함
//		Collections는 기본자료형 배열로 하지 말고 객체자료형 배열로 해야한다.
//		int[] --->Integer[]
		Integer[] ar1 = new Integer[5];
		ar1[0] = 27;
		ar1[1] = 8;
		ar1[2] = 46;
		ar1[3] = 17;
		ar1[4] = 33;
		
		Arrays.parallelSort(ar1,Collections.reverseOrder());
		for(int i=0;i<ar1.length;i++) {
			System.out.printf("%-3d",ar1[i]);
		}
		
		//실수형 5개를 저장하는 배열
		double[] ar2 = new double[5];
		Double[] ar3 = new Double[5];
		
		//자료형
		char c = 'A';
		Character c1 = 'A';
		
		boolean b = true;
		Boolean b2 = true;
	}

}
