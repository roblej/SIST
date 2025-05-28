package pm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ex4_InputStream {
	public Ex4_InputStream(){
		
	}
	
	public static void main(String[] args) {
		//특정 파일과 연결된 스트림 생성
//		new Ex4_InputStream();
		String path = "c:/my_study/sist/io_test/inputtest.txt";
		
		File f = new File(path);
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(f);
			
			int code =-1;
			while((code=fis.read())!=-1)
				System.out.write(code);
//			System.out.print((char)code);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("예외발생:파일이 있는지 확인");
		}finally {
			try {
				fis.close();//사용된 스트림 닫기//엄청중요
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}
}
