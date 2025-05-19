package am;

public class Ex5_Varargs {
	public void test(int ... n) {
		System.out.println("Varargs개념의 지역변수(n)은 배열개념이 된다.");
		System.out.println(n.length);
		
		for(int i=0;i<n.length;i++) {
			System.out.println(n[i]);
			
		}
	}
}
