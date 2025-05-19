package am;

public class Ex7_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex7_Sedan g1 = new Ex7_Sedan();
		g1.setModel("그랜저300");
		g1.setPrice(2700);
		g1.setSunroof(true);
		
		Ex7_Sedan g80 = new Ex7_Sedan();
		g80.setModel("제네시스G80");
		g80.setPrice(8000);
		g80.setSunroof(false);
		
		if(g1.equals(g80)) {
			System.out.println(true);
		}
		else
			System.out.println(false);
	}

}
