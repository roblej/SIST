package am;

public class Ex6_Oper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//대입연산자: =,+=,-=.*=,/=,%=
		//우선순위 가장 낮음
		int a = 7;
		int b = 5;
		
		int c = 0;
		c += a;//c= c+a
		System.out.println("c+=a:"+c);
		c+=b;
		System.out.println("c+=b:"+c);
		c*=b;
		System.out.println("c* =b:"+c);
//		산술연산자 +-*/%
//		비교언산자 >=<= == !=
//		논리연산자 %% || 
//		증감연산자 ++ --
//		삼항연산자 (a>b)?a:b
//		대입연산자 = += -= *= %= /=
//		비트연산자 & | ^ << >>
	}

}
