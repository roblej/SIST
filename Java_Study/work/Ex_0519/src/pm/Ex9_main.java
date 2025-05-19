package pm;

public class Ex9_main {
	public void test(Ex9_Parent p) {
		System.out.println(p.getValue());
	}
	
	public static void main(String[] args) {
		Ex9_Child1 c1 = new Ex9_Child1();
		Ex9_Child2 c2 = new Ex9_Child2();
		
		Ex9_main main = new Ex9_main();
		
		main.test(c1);
		main.test(c2);
		
	}
}
