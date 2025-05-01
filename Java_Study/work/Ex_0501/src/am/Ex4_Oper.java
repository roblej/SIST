package am;

public class Ex4_Oper {
	public static void main(String[] args) {
		char c = 'B';
		++c;
		System.out.println(++c);
		//java의 char은 2byte이며 내부적으로는 유니코드(숫자)로 처리된다.
		
		int ch = 97;
		System.out.println((char)ch);
	}
}
