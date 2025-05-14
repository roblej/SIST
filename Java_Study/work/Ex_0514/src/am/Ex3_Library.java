package am;

public class Ex3_Library {
	Ex3_Book[] ar = new Ex3_Book[5];
	public void setAr() {
		
		ar[0] = new Ex3_Book();
		ar[0].setNum("P-J-100");
		ar[0].setTitle("이것이 자바다");
		ar[0].setPub("한빛미디어");
		ar[0].setPos("A-13");
		ar[0].setRent(true);
		
		ar[1] = new Ex3_Book();
		ar[1].setNum("P-T-120");
		ar[1].setTitle("UML");
		ar[1].setPub("한빛미디어");
		ar[1].setPos("B-103");
		ar[1].setRent(true);
		
		ar[2] = new Ex3_Book();
		ar[2].setNum("P-T-123");
		ar[2].setTitle("자바 바이블");
		ar[2].setPub("한빛아카데미");
		ar[2].setPos("C-123");
		ar[2].setRent(false);
		
		ar[3] = new Ex3_Book();
		ar[3].setNum("P-H-153");
		ar[3].setTitle("운영체제");
		ar[3].setPub("한빛아카데미");
		ar[3].setPos("D-23");
		ar[3].setRent(false);
		
		ar[4] = new Ex3_Book();
		ar[4].setNum("PNT-223");
		ar[4].setTitle("이것이 우분투 리눅스다");
		ar[4].setPub("한빛아카데미");
		ar[4].setPos("F-3");
		ar[4].setRent(false);
	}
	
	//책 이름으로 검색하는 기능
	public String search(String n) {
		StringBuffer info = new StringBuffer();
		
		for(int i=0;i<ar.length;i++) {
			//배열에 저장된 책 정보를 하나씩 가져온다.
			Ex3_Book book = ar[i];
			//얻어낸 책 정보에서 책 제목만 얻어낸다
			String tt = book.getTitle();
			//tt안에 n이 포함되어있는지? 확인하는 비교
			int idx = tt.indexOf(n);//tt안에 n의 값이 있는 위치값을 변수
									//idx에 저장한다. 만약 n의 값이
									//없다면 idx에는 -1이 저장된다.
			if(idx !=-1) {
				info.append(book.getNum());//도서번호
				info.append("/");
				info.append(book.getTitle());//책이름
				info.append("/");
				info.append(book.getPos());//책위치
				info.append("/");
				info.append(book.getPub());//출반사
				info.append("/");
				if(book.isRent()) 
					info.append("대여가능");
				else
					info.append("대여중");
				info.append("\r\n");
			}
			
			//내 로직
//			if(ar[i].getTitle().contains(n)) {
//				info.append(ar[i].getTitle());
//				info.append("/");
//				info.append(ar[i].getNum());
//				info.append("/");
//				info.append(ar[i].getPos());
//				info.append("/");
//				info.append(ar[i].getPub());
//				info.append("/");
//				info.append(ar[i].isRent());
//				info.append("\n");
//			}
		}
		return info.toString();
	}
}
	