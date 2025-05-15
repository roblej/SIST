package am;

public class Ex1_Test {
	//멤버변수 선언
	private String name;
	private int age;
	
	
//	생성자는 반드시 접근제한자가 있어야 하며, 반환형은 명시하지 않는다.
//	이름은 반드시 클래스명과 같아야한다.
	public Ex1_Test(){
		System.out.println("기본생성자");
	}
	public Ex1_Test(String name,int age) {
		//받은 인자들을 멤버필드에 저장
		this.name = name;
		this.age = age;
//		setName(name);
//		setAge(age);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
