package am;

class char1 {
	int a = 1;
	
	public void print(){
		System.out.println("print1");
	}
}

class char2 extends char1{
	
	@Override
	public void print(){
		System.out.println("Overriding");
	}

	public void print(int b){
		b+=a;
		System.out.println("Overloading and "+b);
	}
	
	public void super1() {
		super.print();
	}
}

public class Ex999 {
	public static void main (String[] args) {
		//프로그램의 시작 - 자바 가상머신(JVM)이 자동으로 호출함
		char1 number = new char1();
		char2 number2 = new char2();
		char1 number3 = new char2();
		
		System.out.println(number.a);
		
		number.print();
		number2.print();
		number2.super1();
		//number3.print(5);
		number3.print();
		number2.print(5);
	}
}
