package pm;

import java.util.Arrays;

public class Ex6_Baseball {
	int strike_count = 0;
	int ball_count = 0;
	int[] ans = new int[3];
	int[] user = new int[3];
	int count = 0;
	boolean dup;
	
	public int getStrike_count() {
		return strike_count;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount() {
		this.count = ++count;
	}
	
	public int[] init() {
		//3자리 랜덤 배열에 집어넣기
		for(int i=0;i<ans.length;) {
			dup=false;
			ans[i]=(int)(Math.random()*9+1);
			for(int j=0;j<i;j++) {
				if(ans[i]==ans[j]) {
					dup=true;
					break;
				}
			}
			if(!dup) i++;
		}
		System.out.println(Arrays.toString(ans));
		return ans;
	}
	
	public int[] myAnswer(String scan) {
		strike_count=0;
		ball_count=0;
		for(int i=0;i<scan.length();i++) {
			char ch = scan.charAt(i);
			user[i] = ch-48;
		}//사용자가 입력한 문자열을 숫자로 변경하여 user에 삽입
		
		return user;
	}
	
	public int strikeCount(int[] com, int[] my) {
	    for (int i = 0; i < com.length; i++) {
	        if (my[i] == com[i]) {
	            strike_count++;
	        }
	    }
	    return strike_count;
	}
	
	public int ballCount(int[] com, int[] my) {
		for(int i=0;i<com.length;i++) {
			if(user[i]==com[(i+1)%com.length]||user[i]==com[(i+2)%ans.length])
				ball_count++;
	        }
		return ball_count;
	}
	    
	
	public String printResult(int[] com, int[] my) {
	    int strikes = strikeCount(com, my);
	    int balls = ballCount(com, my);

	    StringBuffer sb = new StringBuffer();
	    sb.append(strikes).append(" Strikes, ");
	    sb.append(balls).append(" Balls");
	    return sb.toString();
	}
	
	public String result() {
		StringBuffer text = new StringBuffer();
		text.append(getCount());
		text.append("차 시도에 성공!");
		return text.toString();
	}
}
	
	
