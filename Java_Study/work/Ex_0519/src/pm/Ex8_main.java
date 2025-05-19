package pm;

import am.Ex7_Car;
import am.Ex7_Sedan;

public class Ex8_main {
	
	public void test(Ex7_Car n) {
		System.out.println(n.getPrice());
		//인자로 넘어온 n이 가리는 인스턴스안에 Ex8_SUV
		if(n instanceof Ex8_SUV) {
			//여기는 n이 가리키는 인스턴스 안에 Ex8_SUV가 있을 때만 수행함!
			Ex8_SUV suv = (Ex8_SUV)n;
			System.out.println(suv.isHud());
		}else if(n instanceof Ex7_Sedan) {
			Ex7_Sedan sedan = (Ex7_Sedan)n;
			System.out.println(sedan.isSunroof());
		}
	}//캐스팅은 성능에 좋지 않음. 이걸 해결하기 위해 나온게 제네릭타입
	public void test(Ex8_SUV n) {
	//그럼 오버로딩하면 되지않나?	
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex8_SUV gv90 = new Ex8_SUV();
		gv90.setModel("GV90");
		gv90.setPrice(100000);
		gv90.setHud(true);
		
		Ex7_Sedan g90 = new Ex7_Sedan();
		g90.setModel("G90");
		g90.setPrice(9000);
		g90.setSunroof(true);
		
		Ex8_main a = new Ex8_main();
		a.test(gv90);
		a.test(g90);
	}

}
