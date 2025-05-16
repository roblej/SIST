package pm;

public class Ex4_Emp {
	private String num;
	private String name;
	private String position;	
	private String department;
	
	public Ex4_Emp(String num,String name,String position,String department) {
		this.num = num;
		this.name = name;
		this.position = position;
		this.department = department;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;	
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
}
