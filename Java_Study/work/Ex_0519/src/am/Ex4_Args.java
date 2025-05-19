package am;

public class Ex4_Args {
	public void test(int n) {
		++n;
		System.out.println(n);
	}
	
	//오버로딩(중복정의) -> 함수명 동일, 인자의 갯수 차이
	public void test(int n,int m) {
		++n;
		++n;
		System.out.println(n);
	}
	
	public void test(int n,int m, int x) {
		++n;
		++n;
		++n;
		System.out.println(n);
	}
}
