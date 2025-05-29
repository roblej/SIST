package am;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Ex4_BufferedOutput {
	public static void main(String[] args) {
		File f = new File("c:/my_study/sist/test/abc.txt");
		//파일이 존재하지 않을 경우에는 그만하고 싶다면.....
		if(!f.exists())
			return;
		BufferedOutputStream bos=null;
		try {
			bos = new BufferedOutputStream(new FileOutputStream(f));
			
			Scanner scan = new Scanner(System.in);
			System.out.println("입력:");
			String msg = scan.next();
			
			byte[] buf = msg.getBytes();
			
			bos.write(buf,0,buf.length);
			bos.flush();	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(bos!=null)
					bos.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
