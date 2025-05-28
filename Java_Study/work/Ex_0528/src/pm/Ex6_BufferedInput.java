package pm;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Ex6_BufferedInput {
	public static void main(String[] args) {
		String path = "c:/my_study/sist/java_study/work/ex_0528/src/pm/Ex5_FileInput.java";
		
		File f = new File(path);
		
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		
		try {
			fis = new FileInputStream(f);
			bis = new BufferedInputStream(fis);
			int size = -1;
			byte[] buf = new byte[2048];//**********
			while((size = bis.read(buf))!=-1) {
				String str = new String(buf,0,size);
				System.out.println(str);
			}
			//위는 배열 buf의 0번지부터 size가 기억하고 있는 번지까지
			//가져와서 문자열로 만든다.(0~1047)
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fis.close();
				bis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
	}
}
