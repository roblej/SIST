package pm;

import java.io.File;

public class Ex3_File {
	
	String path = "c:/my_study/sist/io_test/sist";
	
	File f = new File(path);
	
	public Ex3_File() {
		if(!f.exists()) 
			f.mkdirs();//폴더 생성
		
		
	}
	
	public static void main(String[] args) {
		new Ex3_File();
	}
}
 