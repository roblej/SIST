package pm;

import java.io.IOException;
import java.util.ArrayList;

public class ChatRoom {
	ArrayList<CopyClient> ru_list;//방에 참여한 사용자들
	String roomName;
	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	ChatServer server;
	public ChatRoom(String n,ChatServer server) {
		this.roomName = n;
		this.server = server;
		//현재 ru_list에서 삭제가 된 후 다시
		//ChatServer에 있는 u_list에 CopyClient를 추가해야하기 때문에 필요하다.
		ru_list = new ArrayList<CopyClient>();


	}

	public void sendMsg(Protocol p) {//현재 방에 접속되어 있는 모든 사용자들에게
									//데이터를 전달하는 기능

//		for(int i=0;i<ru_list.size();i++) {
//			CopyClient cc = ru_list.get(i);
		for(CopyClient cc:ru_list) {//개선된 루프

			try {
				cc.out.writeObject(p);
				cc.out.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public String[] getNames() {
		//ArrayList에 있는 요소들에게 이름을 받아서 배열화시킨다.

		String[] names = new String[ru_list.size()];
		int i=0;
		for(CopyClient cc : ru_list) {
			names[i++] = cc.getNickName();
		}

		return names;
	}

	public void getOut(CopyClient cc) {//방 나가기
		ru_list.remove(cc);

		//만약 지금 나가는 CopyClient가 마지막 일 때
		//현재 방은 삭제되어야 한다
		if(ru_list.size()<1) {
		server.r_list.remove(this);
		server.addClient(cc);
		}else {
			//아직 방에 남아있는 사람이 있는 경우
			//명단 갱신과 메세지 전달을 해야한다
		Protocol protocol = new Protocol();
		protocol.setCmd(3);
		protocol.setUser_names(getNames());
		protocol.setMsg(cc.nickName+"님 퇴장\r\n");

		}
	}
	
	public ArrayList<CopyClient> getRu_list() {
		return ru_list;
	}

	public void setRu_list(ArrayList<CopyClient> ru_list) {
		this.ru_list = ru_list;
	}

	public void joinUser(CopyClient cc) {//방 참여
		ru_list.add(cc);
		
		//원본클라이언트에게 전달할 프로토콜은 다시 작업한다
		//방에 참여한 참여자 명단 수집
	
		Protocol protocol = new Protocol();
		protocol.setCmd(4);
		protocol.setUser_names(getNames());
		protocol.setMsg(cc.nickName+"님 입장\r\n");
		
		//준비된 프로토콜은 현재 방에 참여된 사용자들에게만 보내야함
		sendMsg(protocol);
	}
}
