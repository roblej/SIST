package pm;

import java.util.Scanner;

public class Ex13_if {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 키보드로부터 점수를 하나 받아 score에 저장. 범위:0~100
		 * 그 점수가 80~100 이면 우수
		 * 60~79보통
		 * 40~59 좀 걱정
		 * 그 이하는 나오지마
		 * 
		 */
		System.out.println("0~100 사이 점수 입력 : ");
		
		Scanner scan = new Scanner(System.in);
		int score = scan.nextInt();
		
		String str = "";
		
		if(score>=0&&score<=100) {
			if(score>=80) str = "우수";
			else if(score>=60) str ="보통";
			else if(score>=40) str ="좀 걱정";
			else str="나오지 마!";
		}else {
			str="오류입니다";
		}
		
		System.out.println(str);
		
		scan.close();
	}

}
