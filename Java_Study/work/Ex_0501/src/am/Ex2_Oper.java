package am;

public class Ex2_Oper {
	public static void main(String[] args) {
		//증감연산자 : ++,--
		int a = 8;
		int b = ++a + 3;
		System.out.println("a = "+a);
		System.out.println("b = "+b);
		
		b = a++ + 3; // 후위연산, 9++ + 3 = 12 이후 a=10
		System.out.println("b = "+b);
		System.out.println("a = "+a);
		
		System.out.println(a++);
		System.out.println(a);
		
		
	}
}
