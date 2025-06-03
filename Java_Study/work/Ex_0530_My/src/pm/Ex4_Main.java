package pm;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Ex4_Main {
	public static void main(String[] args) {
		String path = "C:/Users/TEN/Documents/GitHub/SIST/io_test/inputTest.txt";
		File f = new File(path);
		
		//저장할 객체
		Ex4_Data data = new Ex4_Data();
		data.setName("홍길동");
		data.setAge(28);
		
		Ex4_Data data2 = new Ex4_Data();
		data2.setName("을불");
		data2.setAge(20);
		
		Ex4_Data data3 = new Ex4_Data();
		data3.setName("이도");
		data3.setAge(31);
		
		ArrayList<Ex4_Data> list = new ArrayList<>();
		list.add(data);
		list.add(data2);
		list.add(data3);
		
		// 객체를 저장하기위해 필요한 스트림
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(f));
//			oos.writeObject(data);//객체 쓰기(저장)
			oos.writeObject(list);
			oos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(oos != null)
					oos.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

}
