package am;

public class Ex1_While {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 while문의 구성
		 
		 while(조건식){
		 조건식에 만족 시  수행하는 문장1;
		 조건식에 만족 시  수행하는 문장2;
		 }
		 1~10까지 반복하는 while문 작성!
		 */
		int i = 0;
		while(i<10) {
			System.out.println(++i);
		}//while문의 끝
//		while문을 사용할때 조심해야할것은
//		조건식을 언젠가는 불만족 시킬 수 있도록 증감 또는
//		다른 식으로 구현해야한다
	}

}
