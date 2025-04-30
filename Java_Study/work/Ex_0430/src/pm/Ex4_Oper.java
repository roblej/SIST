package pm;

public class Ex4_Oper {
	public static void main(String[] args) {
		byte b1 = 10;
		byte b2 = 7;
		long b3 = b1+b2;
		System.out.println("b1 + b2 = "+ b3);
		long b4 = b1-b2;
		System.out.println("b1 - b2 = "+ b4);
		long b5 = b1*b2;
		System.out.println("b1 * b2 = "+ b5);
		long b6 = b1/b2;
		System.out.println("b1 / b2 = "+ b6);
		long b7 = b1%b2;
		System.out.println("b1 % b2 = "+ b7);
		
		System.out.printf("b1+b2=%d\n",b3);
		
		char a1 = 'A';
		System.out.printf("%d\n",(byte)a1);
		System.out.println(Byte.toString(b1)+b2);
		//연산자는 피연산자가 하나라도 문자열이 있다면
		//다른 피연산자 또한 문자열로 자동 변환됨
		
		//실수형:float, double
		float f1 = 3.14f;//자바에서 소수점을 가지는 값들은 기본적으로 double
		//float로 인식하기 위해 f/F를 붙임
		double d1 = 2.1;
		double d2 = f1%d1;
		System.out.println("f1%d1="+d2);//3.14를 2.1로 나누고 나머지값을 변수 d2에 저장
	}
}
