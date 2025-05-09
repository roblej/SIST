package pm;

import java.util.Arrays;

public class Ex8_Array {
	public static void main(String[] args) {
/*
	로또번호추첨기
	6개의 번호를 난수로 출력한다
	중복은 나오지 않는다
	배열로 만들자
	boolean 변수 dup을 false로 선언 및 생성
	temp만들어 배열[0]을 temp에 넣고, temp를 배열[1]~[5]까지 비교해가며
	temp의 값이 배열 n의 값에 있을경우 boolean변수 dup을 true로 만들자
	다시 난수를 발생시키고 다시 [1]~[5]을 비교
 */
		
		int[] lotto = new int[6];
		boolean dup = false;
		
		for(int i=0;i<lotto.length;i++) {
			lotto[i] = (int)(Math.random()*45+1);
			
			if(i!=0) {
				do {
					dup = false;
					for(int j=0;j<i;j++) {
						if(lotto[i]==lotto[j]) {
							dup = true;
							lotto[i] = (int)(Math.random()*45+1);
						}
					}
				}while(dup);
			}
		}
		for(int i=0;i<lotto.length;i++)
			System.out.printf("%d\s",lotto[i]);
		
		System.out.println("\n===========================");	
		
		lotto = new int[6];
		dup = false;
		
 		//챗지피티의 반복 두번만에 끝내기<<<<절대 생각 못했을듯
		for(int i=0;i<lotto.length;) {
			dup = false;
			lotto[i] = (int)(Math.random()*45+1);
			
			for(int j=0;j<i;j++) {
				if(lotto[i]==lotto[j]) {
				dup = true;
				break;
				}
			}
			if(!dup) i++;
		}
		Arrays.sort(lotto);
		for(int i=0;i<lotto.length;i++)
			System.out.printf("%d\s",lotto[i]);

		
		
		
		
		
		
		//초보자용 코드
		/*
		lotto = new int[6];
		for(int i=0;i<lotto.length;i++) {
			lotto[i] = (int)(Math.random()*45+1);
			
			for(int j=0;j<i;j++) {
				if(lotto[i]==lotto[j]) {
					i--;
				break;
				}
			}
		}
		for(int i=0;i<lotto.length;i++)
			System.out.printf("%d\s",lotto[i]);
		 */
		
		
	}
}
