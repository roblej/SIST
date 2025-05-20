package am;



public class Ex1_main {
	
	public void test(Ex1_Parent n) {
		n.myData();//사용 범위가 부모로 재설정 되어있지만
//		myData함수는 재정의가 되었으므로 부모의 myData가 숨겨지고
//		자식의 myData가 우선권을 가져 사용범위에서 벗어났ㅇ느ㅏ
//		myData는 자식의 함수가 호출된다.
		System.out.println(n.getValue());
	}
	
	
	public static void main(String[] args) {
		Ex1_Child c = new Ex1_Child();
		
		Ex1_main main = new Ex1_main();
		main.test(c);
	}
}
