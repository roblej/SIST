package pm;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Ex5_Main {
	
	public static void main(String[] args) {
		String path = "C:/Users/TEN/Documents/GitHub/SIST/io_test/inputTest.txt";
		File f = new File(path);
		
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(f));
			
			Object obj = ois.readObject();
			ArrayList<Ex4_Data> al = (ArrayList<Ex4_Data>)obj;
			
			for(int i=0;i<al.size();i++) {
				Ex4_Data data = al.get(i);
				System.out.printf("이름:%s,나이:%d\r\n",data.getName(),data.getAge());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if( ois != null )
				try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}
