package pm;

public class Ex4_main {
	public static void main(String[] args) {
		String s1= new String("SiST");
		String s2 = s1.concat("교육센터");
		
		System.out.println("s1: "+s1);
		System.out.println("s2: "+s2);
		
		//String은 편집할 수 없다. 무조건 새로 만들어진다.
		//문자열 편집을 위해 StringBuffer을 사용하자
		StringBuffer sb = new StringBuffer("SiST");
		StringBuffer sb2 = sb.append("교육센터");
		
		System.out.println("sb:"+sb.toString());
		System.out.println("sb2:"+sb2.toString());
		
		if(sb==sb2)
			System.out.println("주소 일치");
		else
			System.out.println("주소 다름");
	}
}
