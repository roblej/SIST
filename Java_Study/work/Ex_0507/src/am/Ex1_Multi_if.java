package am;

public class Ex1_Multi_if {
	public static void main(String[] args) {
		//1~10까지 수들 중 난수 발생
		// Math.Random()*범위+시작수
		int ran = (int)(Math.random()*10+1);

		//ran값이 짝수?홀수? 판단 ㄱㄱ
		// 짝수란 2로 나눴을때 나머지가 0인 값
		if(ran%2 == 0) {
			//짝수
			System.out.println(ran+"은 짝수");
		}else {
			//홀수
			System.out.println(ran+"은 홀수");
		}
		
	}
}
