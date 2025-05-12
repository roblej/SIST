package pm;

import java.util.Arrays;
import java.util.Scanner;

public class Ex7_NumBaseball {
	public static void main(String[] args) {
		/*
		숫자야구
		1~9 중복을 제외한 3자리(노출되지않음) ex)4 3 9
		1차 : 345 엔터-> 0스트라이크 2볼
		 */
		int strike_count = 0;
		int ball_count = 0;
		int[] ans = new int[3];
		int[] user = new int[3];
		
		int count = 1;
		boolean dup;
		
		
		//3자리 랜덤 배열에 집어넣기
		for(int i=0;i<ans.length;) {
			dup=false;
			ans[i]=(int)(Math.random()*9+1);
			for(int j=0;j<i;j++) {
				if(ans[i]==ans[j]) {
					dup=true;
					break;
				}
			}
			if(!dup) i++;
		}
//		for(int i=0;i<ans.length;i++)
//			System.out.printf("%d\s",ans[i]);
//		System.out.println();
		
		System.out.println("3자리 숫자를 입력하세요:");
		Scanner scan = new Scanner(System.in);
		do {
			strike_count=0;
			ball_count=0;
			System.out.print(count++ +"차 시도:");
			String str = scan.nextLine();
			for(int i=0;i<str.length();i++) {
				char ch = str.charAt(i);
				user[i] = ch-48;
			}//사용자가 입력한 문자열을 숫자로 변경하여 user에 삽입
			
			//스트라이크 카운트하는 반복문
			for(int i=0;i<str.length();i++) {
				if(user[i] == ans[i]) {
					strike_count++;
				}else {
					for(int j=0;j<str.length();j++) {
						if(user[i]==ans[j]) {
							ball_count++;
						}
					}
				}
			}
			if(strike_count==3) {
				System.out.println("홈런");
			}else
				System.out.printf("%d 스트라이크,%d 볼\n",strike_count,ball_count);
			
		}while(strike_count !=3);
		
		
	}
}
