package pm;

import java.io.Serializable;

public class Protocol_my implements Serializable{
	int cmd; // 1:접속, 2:채팅메세지, 3:종료
	String name;
	
	public int getCmd() {
		return cmd;
	}
	public void setCmd(int cmd) {
		this.cmd = cmd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
