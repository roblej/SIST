package am;

public class Ex2_main {
	public static void main(String[] args) {
		Ex2_Ref r1 = new Ex2_Ref();
		int[] ar = {100,200,300};
		
		r1.test(ar);
		System.out.println(ar[0]);
	}
}
