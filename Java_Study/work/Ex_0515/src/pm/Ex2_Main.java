package pm;

public class Ex2_Main {
	public static void main(String[] args) {
		Ex2_Test<Integer> t1 = new Ex2_Test<Integer>();
		
		t1.setValue(1);
		
		System.out.println(t1.getValue());
		
		Ex2_Test<String> t2 = new Ex2_Test<String>();
		t2.setValue("10000");
		
		System.out.println(t2.getValue());
		
		Ex2_Test<Boolean> t3 = new Ex2_Test<Boolean>();
		t3.setValue(true);
		
		System.out.println(t3.getValue());
	}
}
