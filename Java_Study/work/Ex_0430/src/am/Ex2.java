package am;

public class Ex2 {
	public static void main(String[] args) {
		//프로그램 시작
		
		//변수 선언
		//변수는 자료형을 크게 2가지로 나눠진다.
		//1)기본자료형 2)객체(참조)자료형
		//1)기본자료형 
		// boolean: true(참), false(거짓)
		boolean b1 = true; // 변수 선언
		System.out.println(b1); // 문장의 끝은 반드시 세미콜론(;)
		b1 = false;
		System.out.println(b1);
		// char:하나의 문자를 기억하는 자료형 문자는 홑따옴표로 구분함
		char b2 = 'A';
		System.out.println(b2); // sysout ctrl+space
		b2 = 'B'; //변수 사용(값 변경)
		System.out.println(b2);
		//정수형 변수 선언 : byte:-128~127 8bit, short:-32768~32767 16bit, int:21억 32bit, long:64bit
		byte b3 = 127;
		short b4 = 32767;
		int b5 = 2147483647;
		System.out.println(b4+b5);
		System.out.println(b4-b5);
		long b6 = 2147483648111111111L; //long형의 값을 의미할 때는 값 뒤에 l또는L을 기술한다
		System.out.println(b6);
		//
		//
	}
}
