package com.sist.ex0930_docker.util;

import java.io.File;

public class FileRenameUtil {
    public static String CheckSameFileName(String fileName,String path){
        //인자인 filename에서 확장자를 뺀 파일명 가려내자.
        // 우선 "."의 위치를 찾자
        int index = fileName.lastIndexOf(".");//test.txt-> 4
        String f_name = fileName.substring(0,index);//test
        String suffix = fileName.substring(index);//.txt

        //전체경로(절대경로+파일명)
        // String saveFilePath = path + "/" + fileName;
        String saveFilePath = path + System.getProperty("file.separator") + fileName;

        //위 경로를 가지고 전체경로로 활용하여 파일객체 생성
        File f = new File(saveFilePath);

        //파일이 이미 있다면,파일명 뒤에 숫자를 붙이기 위해 변수 준비
        int idx = 1;

        //동일한 이름의 파일이 존재하는지 체크
        while(f.exists()){//파일이 존재하면 true, 존재하지 않으면 false
            //파일ㅇ ㅣ이미 존재하고 있는 파일일 때
            StringBuffer sb = new StringBuffer();
            sb.append(f_name);
            sb.append(idx++);
            sb.append(suffix);

            fileName = sb.toString();

            //변경된 파일명으로 다시 전체경로를 구성
            saveFilePath = path + System.getProperty("file.separator") + fileName;

            //변경된 파일명으로 파일객체 생성
            f = new File(saveFilePath);

            idx++;
        }
        return fileName;
    }
}
