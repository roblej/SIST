package am;

public class Ex5_Array {
	public static void main(String[] args) {
//		문자를 4개를 저장할 수 있는 배열을 생성 후
//		반복을 이용하여 'A','B','C','D'가 저장되도록 초기화
		
		char ar[] = new char[4];
		
		for(int i=0;i<ar.length;i++) {
//			ar[i]=(char)(65+i);
			ar[i]=(char) ('A'+i);
			System.out.print(ar[i]);
		}
		System.out.println("\n======================");
		char ch='A';
		for(int i=0;i<ar.length;i++) {
			ar[i]= ch;
			ch++;
			System.out.print(ar[i]);
		}
	}
}
