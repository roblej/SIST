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
	
	public void setStrike_count(int strike_count) {
		this.strike_count = strike_count;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount() {
		this.count = ++count;
	}
	
	public void setBall_count(int ball_count) {
		this.ball_count = ball_count;
	}

	public void init() {
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
	}
	
	public void myAnswer(String scan) {
		for(int i=0;i<scan.length();i++) {
			char ch = scan.charAt(i);
			user[i] = ch-48;
		}//사용자가 입력한 문자열을 숫자로 변경하여 user에 삽입
	}
	
	public int strikeCount() {
	    for (int i = 0; i < ans.length; i++) {
	        if (user[i] == ans[i]) {
	            strike_count++;
	        }
	    }
	    return strike_count;
	}
	
	public int ballCount() {
		for(int i=0;i<ans.length;i++) {
			if(user[i]==ans[(i+1)%ans.length]||user[i]==ans[(i+2)%ans.length])
				ball_count++;
	        }
		return ball_count;
	}
	    
	public String printResult() {
	    int strikes = strikeCount();
	    int balls = ballCount();

	    StringBuffer sb = new StringBuffer();
	    sb.append(strikes);
	    sb.append(" Strikes, ");
	    sb.append(balls);
	    sb.append(" Balls");
	    return sb.toString();
	}
	
	public String result() {
		StringBuffer text = new StringBuffer();
		text.append(getCount());
		text.append("차 시도에 성공!");
		return text.toString();
	}
}