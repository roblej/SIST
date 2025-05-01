package am;

public class Ex1_Oper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 13;
		int b = 7;
		
		int c = a&b; //비트연산자의 논리곱
		//0000 1101 = 13
		//0000 0111 = 7
		//&--------------
		//0000 0101 = 5
		
		//OR 연산시는? 1101 = 15 
		System.out.println(c);
		
	}

}
