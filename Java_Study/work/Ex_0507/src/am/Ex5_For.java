package am;

public class Ex5_For {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1~10까지 반복하여 출력하는 for문
		
		/*
		 * [for의 구성]
		 * for(초기식;조건식;증감식)
		 * 조건식에 만족할 때 수행하는 문장;
		 */
		
		for(int su=1;su<=10;su++) {
			System.out.println(su);
		}
		System.out.println("------------------------------");
		for(int i=0; i<10;i+=1) {
			System.out.println(i);
		}
		for(;;) {
			System.out.println("forever");
		}
	}

}
              