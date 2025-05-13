package pm;

public class Ex3_Gugudan {
	private int dan;
	
	public void setDan(int n) {
		dan = n;
	}
	public int getDan() {
		return dan;
	}
	
	public void print(){
		for(int i=1;i<10;i++) {
			System.out.printf("%d * %d = %d\n",dan,i,dan*i);
		}
	}

	public String[] post() {
		String[] a=new String[9];
		
		for(int i=1;i<10;i++)
			a[i-1]=dan+"*"+i+"="+(i*dan);
		
		return a;
	}
	
	
}
