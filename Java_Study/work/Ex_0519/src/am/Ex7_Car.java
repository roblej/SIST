package am;

public class Ex7_Car {
	private String model;//모델명
	private int min_price;//최소금액
	private String type; //타입:소형세단 중형세단 suv 트럭
	
	//모델명을 변경하는 기능
	
	public void setModel(String n) {
		this.model = n;
	}
	
	//최소 가격을 반환하는 기능
	public int getPrice() {
		return min_price;
	}
	
	//최소 가격을 변경하는 기능
	public void setPrice(int n) {
		this.min_price = n;
	}
	
	
}
