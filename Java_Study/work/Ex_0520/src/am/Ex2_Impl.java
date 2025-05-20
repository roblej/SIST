package am;

public class Ex2_Impl implements Ex2_Inter {
	int su = 20;
	
	@Override
	public int getValue() {
		System.out.println("impl");
		return MAX_VALUE*su;
	}

}
