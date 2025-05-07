package am;

public class Ex4_Switch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//문제)1~20까지의 수들 중 난수를 받아 su라는 변수에 저장ㅎ나다.
		//su으 ㅣ값이 짝수? 홀수? switch문으로 구동
		
		int su = (int)(Math.random()*20+1);
		
		switch(su%2) {
		case 0:
			System.out.println(su+"는 짝수");
			break;
		case 1:
			System.out.println(su+"는 홀수");
			break;	
		default:
			System.out.println("error");
		}
	}

}
