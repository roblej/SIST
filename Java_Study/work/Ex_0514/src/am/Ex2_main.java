package am;

public class Ex2_main {
	public static void main(String[] args) {
		
		Ex2_Member[] ar = new Ex2_Member[3]; // Ex2_Member이 들어갈 3사이즈의 배열 ar을 생성, 아직 그 안에 각 클래스가 생성되어있지는 않음.
		
		for(int i=0;i<ar.length;i++) { //이제 생성
			ar[i]= new Ex2_Member();
		}
		ar[0].setName("마루치");
		ar[0].setPhone("010-0000-0000");
		
		ar[0].setName("아라치");
		ar[0].setPhone("010-0000-0001");
		
		ar[0].setName("파란해골");
		ar[0].setPhone("010-0000-0002");
		
	}
}
