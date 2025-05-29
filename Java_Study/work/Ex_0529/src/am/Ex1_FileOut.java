package am;

import java.io.File;
import java.io.FileOutputStream;

public class Ex1_FileOut {
	public static void main(String[] args) {
		
	String path = "c:/my_study/sist/test/abc.txt";
	
	//위의 존재하지 않는 경로로 File객체 생성
	File f = new File(path);
	try {
		FileOutputStream fos = new FileOutputStream(f);
	}catch(Exception e){
		e.printStackTrace();
	}
	}
	
}
