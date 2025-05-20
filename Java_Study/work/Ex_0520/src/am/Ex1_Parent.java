package am;

public class Ex1_Parent {
	int value;
	
	public Ex1_Parent(int n) {
		this.value = n;
	}
	
	public void myData() {
		System.out.println("Parent mydata");
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	
}
