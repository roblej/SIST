package am;

public class Ex3_Class implements Ex2_Inter,Ex3_Inter {
	int value = 100;

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("Ex3_Class의 print");
	}

	@Override
	public void testValue() {
		// TODO Auto-generated method stub
		System.out.println("Ex3_Class의 testValue");
	}

	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return value;
	}
	
	public void myTest() {
		System.out.println("Ex3_Class의 myTest");
	}
}
