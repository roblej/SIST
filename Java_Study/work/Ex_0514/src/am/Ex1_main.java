package am;

public class Ex1_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex1_Car c1 = new Ex1_Car();
		
		System.out.println(c1.getModel());
		c1.setModel("우라칸");
		
		System.out.println(c1.getModel());
		
		Ex1_Car c2 = new Ex1_Car();
		c2.setModel("소나타");
		System.out.println(c2.getModel());
		
	}

}
