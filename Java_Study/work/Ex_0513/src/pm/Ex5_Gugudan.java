package pm;

public class Ex5_Gugudan {
	private int dan;

	public void setDan(int dan) {
		this.dan = dan;
	}
	public String result() {
		//문자열을 편집하기 위해 필요한 객체 생성
		StringBuffer sb = new StringBuffer();
		sb.append(dan);
		sb.append("단\r\n");
		sb.append("---------\r\n");
		
		for(int i=1;i<10;i++) {
			sb.append(dan);
			sb.append("*");
			sb.append(i);
			sb.append("=");
			sb.append(i*dan);
			sb.append("\r\n");
		}
			
		return sb.toString();
	}
}
