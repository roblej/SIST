package pm;

public class Ex4_ven {
	Ex4_drink[] ar = new Ex4_drink[4];
	String[] able = new String[ar.length];
	int insert_coin = 0;
	
	public void setAr() {
		ar[0] = new Ex4_drink();
		ar[0].setD_name("레쓰비");
		ar[0].setPrice(500);
		
		ar[1] = new Ex4_drink();
		ar[1].setD_name("사이다");
		ar[1].setPrice(900);
		
		ar[2] = new Ex4_drink();
		ar[2].setD_name("콜라");
		ar[2].setPrice(700);
		
		ar[3] = new Ex4_drink();
		ar[3].setD_name("웰치스");
		ar[3].setPrice(1000);
	}
	
	public String[] insert(int coin){
		insert_coin = coin;
		int j = 0;
		for(int i=0;i<ar.length;i++) {
			Ex4_drink drink = ar[i];
			if(drink.getPrice()<=coin) {//넣은 돈보다 작은 음료 발견
				able[j]=drink.getD_name();//able배열에 해당 음료 이름 삽입
				j++;//able index 증가
			}
		}
		if(j==0) {
			System.out.println("금액이 부족합니다");
			System.exit(0); // 프로그램 종료
		}
			
		
		return able;
	}
	
	
	public int choice(int n) {
		int change=0;
		for(int i=0;i<ar.length;i++) {
			if(ar[i].getD_name()==able[n-1]) {//able중에서 선택한 음료를 원 배열에서 찾기
				change =insert_coin - ar[i].getPrice();//넣은 돈 - 선택한 음료의 가격
				break;
			}
		}
		return change;
	}
	
	public Ex4_drink getDrink(int i) {
		
		
		return ar[i-1];
	}
	
	/*	
	public String insert(int n) {//2차원배열을 생성, 순서대로 이름과 값 넣기를 원하는데......
		StringBuffer sb = new StringBuffer();
		insert_coin = n;
		for(int i=0;i<ar.length;i++) {
			if(ar[i].getPrice()<=n) {//넣은 돈보다 작은 음료 발견
				sb.append(i+1);
				sb.append("\s");
				sb.append(ar[i].getD_name());
				sb.append("\t");
				//여기에 넣어야하는데 위에거 지우고
			}
		}
		return sb.toString();
	}
	
	public int choice(int n) {
		int enough = insert_coin-ar[n-1].getPrice();
		return enough;
	}
	 */
}
