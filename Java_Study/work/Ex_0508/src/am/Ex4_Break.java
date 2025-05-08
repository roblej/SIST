package am;

public class Ex4_Break {

	public static void main(String[] args) {
		// TODO 문자열을 기억하는 str이라는 변수 선언
		String str = "100239384";
		//str이 기억하는 문자열의 길이만큼 반복문을 수행
		int i=0;
		while(i<str.length()) {
			char ch = str.charAt(i);
			if(ch>='5') break;
			
			++i;
			System.out.printf("%-2c",ch);
		}
	}

}
