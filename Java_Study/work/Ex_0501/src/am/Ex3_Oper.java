package am;

public class Ex3_Oper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10;
		int b = 7;
		boolean res = (10>=a++)||(++b>7);
		//true->a=11 참이니까 || 뒤 안봄 b는 그대로 7
		
		System.out.println(res);
	}

}
