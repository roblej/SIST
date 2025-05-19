package pm;

public class Ex9_Child1 extends Ex9_Parent {
	private String msg ="Child1";
	private int value; //0
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getValue() {
		System.out.println("C1");
		return value;//부모의 value가 아닌 자신의 value
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	
	
}
