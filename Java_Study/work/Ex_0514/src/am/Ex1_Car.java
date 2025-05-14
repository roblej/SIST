package am;

public class Ex1_Car {
	//자동차 모델명, 제조사, 배기량, 보험가입여부, 마지막 정비일
	private String model = "범블비";
	private String comp;
	private final int cc = 3300;
	private boolean insured;
	private String last_repair;
	
	public String getComp() {
		return comp;
	}
	public void setComp(String comp) {
		this.comp = comp;
	}
	
	public boolean isInsured() {
		return insured;
	}
	public void setInsured(boolean insured) {
		this.insured = insured;
	}
	
	public String getLast_repair() {
		return last_repair;
	}
	public void setLast_repair(String last_repair) {
		this.last_repair = last_repair;
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	public int getCc() {
		return cc;
	}
	
	
}
