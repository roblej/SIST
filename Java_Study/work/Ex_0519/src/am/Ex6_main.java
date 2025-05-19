package am;

public class Ex6_main {
	public static void main(String[] args) {
		Ex6_Child child = new Ex6_Child();
		
		int money = child.getMoney();
		System.out.printf("%d조원",money);
		
		//Ex6_Child c2 = new Ex6_Parent(); <-안되는 이유 : 생성시 object -> parent까지 생성하고 child를 호출하기때문에 오류 
//		Ex6_Parent child = new Ex6_Child(); -> object->parent->child까지 생성후 2차주소를 parent로 지정하고 범위는 object~parent까지 사용가능. child 사용 불가
	}
}
