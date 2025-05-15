package pm;

import java.util.ArrayList;

public class Ex3_List {
	public static void main(String[] args) {
		//배열과 같은 List구조 생성
		ArrayList<Integer> al = new ArrayList<Integer>(3);
		
		//현재 List구조의 사이즈를 얻어내자!
		int size = al.size();
		System.out.printf("al.size():%d\n",size); //0
		
		al.add(100);
		size = al.size();
		System.out.printf("al.size():%d\n",size); //1
		
		for(int i=1;i<11;i++) {
			al.add(i);
		}
		size = al.size();
		
		System.out.printf("al.size():%d\n",size); //11
		
		//List구조에 저장된 요소들을 하나씩 얻어내어 출력하는 반복문
		for(int i=0;i<al.size();i++) {
			//List구조에 저장된 요소들을 하나씩 얻어낼 때는
			//반드시 저장된 요소의 자료형을 알아야 한다.
			int v1 = al.get(i);
			System.out.printf("%-4d",v1);
		}
		System.out.println();
		
		al.remove(1); // ArrayList에서 1번지, 즉 두번째 요소를 삭제한다.al.get(i)
		
		for(int i=0;i<al.size();i++) {
			int v1 = al.get(i);
			System.out.printf("%-4d",v1);
		}
		
		size = al.size();
		
		System.out.printf("\n삭제 후 al.size():%d\n",size); //11
		
		//원하는 위치에 추가하기 - insert
		al.add(3, 99);
		
		for(int i=0;i<al.size();i++) {
			int v1 = al.get(i);
			System.out.printf("%-4d",v1);
		}
		System.out.println();
		
		boolean res = false;
		int idx=0;
		if(al.contains(99)) {
			res = true;
			idx = al.indexOf(10);
		}
		System.out.println(res);
		System.out.println(idx);
		
		
		al.clear();
		
		size = al.size();
		System.out.println(size);
		
		//리스트 구조에서 알아야 할 메서드
		// - add : 추가 add(3,400) : 3번위치에 400을 추가
		// - get : 추출
		// - remove : 삭제
		// - size : 저장된 요소수
		// - clear : 모두삭제
		// - contains : 포함여부 확인
		// - isEmpty : 비었는지? 확인
		
	}
	
}
