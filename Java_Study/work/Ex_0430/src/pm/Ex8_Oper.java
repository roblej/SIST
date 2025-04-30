package pm;

public class Ex8_Oper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10;
		int b = 7;
		
//		boolean res = ((a+=2)>10)&&((b+=2)>10);
		boolean res = ((a+=2)>10)||((b+=2)>10);
		System.out.println(a);
		System.out.println(b);
		System.out.println(res);
		System.out.println("---------------");
		
//		res = ((a+=2)>15)&&((b+=2)>15);
		res = ((a+=2)>15)||((b+=2)>15);
		System.out.println(a);//14
		System.out.println(b);//9
		System.out.println(res);//false		
	}

}
