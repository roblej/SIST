package am;

public abstract class Ex1_Abs {
	//추상클래스는 클래스가 abstract로 선언된 클래스를 말함
	//내부에 추상메서드를 하나라도 가지면 해당 클래스는
	//abstract로 선언되어야한다.
	String msg;//변수
	final int V100 = 100;//상수
	
	public int getV100(){ //일반메서드
		return V100;
	}

	public void print() {//Empty Method
		
	}
	
	public abstract void test();//추상메서드 - 미완성적 개념
		
}
