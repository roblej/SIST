package com.sist.ex0903_kakaologin;

import mybatis.vo.MemberVO;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Member;
import java.net.HttpURLConnection;
import java.net.URL;

@Controller
public class LoginControl {
    @Autowired
    private HttpSession session;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/login/kakao")
    public ModelAndView loginKakao(String code) { //카카오서버가 호출하여 코드를 준다.
        ModelAndView mv = new ModelAndView();
        //카카오서버가 인자로 전달해준 인가코드가 code라는 변수 들어옴. 확인 ㄱㄱ
//        System.out.println(code);

        //받은 인증코드를 가지고 2번째 카카오서버와 통신을 하기 위해 준비해서
        //토큰을 요청하여 받아야한다.
        String access_Token = null;
        String refresh_token = null;

        String req_url = "https://kauth.kakao.com/oauth/token";
        try {
            URL url = new URL(req_url);

            //웹상의 경로와 연결하는 객체
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            //카카오서버쪽에서 post방식의 요청을 원하므로 method를 post로 지정
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            //연결된 카카오서버로 파라미터들을 전달하기 위해 스트림 생성
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));

            //카카오API문서에 있는 4개의 파라미터들을 정의하기 위해 문자열 편집
            StringBuffer sb = new StringBuffer();
            sb.append("grant_type=authorization_code");
            sb.append("&client_id=ff54feae9f11b6b20bce9ab7bfd86bf0");
            sb.append("&redirect_uri=http://localhost:8080/login/kakao");
            sb.append("&code=").append(code);

            bw.write(sb.toString());
            bw.flush();

            //카카오서버에 요청을 보낸 후 응답결과가 성공적인 경우(200)
            int res_code = conn.getResponseCode();
//            System.out.println("res_code = " + res_code);
            if (res_code == 200) {
                //요청을 통해 얻은 결과는 JSON타입의 결과 메세지를 읽어온다.
                //그 결과를 받기 위해 스트림 준비
                StringBuffer res = new StringBuffer();
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                String line;
                //한줄 단위로 읽어서 result라는 StringBuffer에 적재한다.
                while ((line = br.readLine()) != null) {
                    res.append(line);
                }
                System.out.println("result =" + res.toString());

            // JSON 파싱 처리 : "access_tocken과 refresh_tocken"을 찾아내어 값을 얻어내야한다.
            JSONParser parser = new JSONParser();

            //위 객체는 json-simple라이브러리가 가지고 있으며 문자열지만 json형식의 결과를 json객체로 만들어주는  parser다
            JSONObject jsonObject = (JSONObject) parser.parse(res.toString());

            access_Token = (String) jsonObject.get("access_token");
            refresh_token = (String) jsonObject.get("refresh_token");

            System.out.println("access_token=" + access_Token);
            System.out.println("refresh_token=" + refresh_token);

            //이제 받은 토큰을 가지고 마지막 3번째 요청으로 사용자 정보를 가져온다.
                String apiURL = "https://kapi.kakao.com/v2/user/me";
                String header = "Bearer " + access_Token;

                url = new URL(apiURL);
                conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);

                //카카오 API의 문서상에 조건이 accsss토큰을 header에 담아 보내야 한다.
                //그래서 헤더 설정을 해야함
                conn.addRequestProperty("Authorization", header);

                res_code = conn.getResponseCode();
                System.out.println("res_code"+HttpURLConnection.HTTP_OK);
                if (res_code == HttpURLConnection.HTTP_OK) {
                    //요청에 성공했을 때
                    BufferedReader brdm = new  BufferedReader(new InputStreamReader(conn.getInputStream()));
                    StringBuffer res2 = new StringBuffer();
                    String line2 = null;
                    while ((line2 = brdm.readLine()) != null) {
                        res2.append(line2);
                    }
                    System.out.println(res2.toString());
                    //받은 json형식의 결과 문자열을 json객체로 변환해야 한다.
                    jsonObject = (JSONObject) parser.parse(res2.toString());

                    JSONObject props  = (JSONObject) jsonObject.get("properties");
                    String nickname = (String) props.get("nickname");
                    String p_img =  (String) props.get("profile_image");

                    JSONObject kakao = (JSONObject) jsonObject.get("kakao_account");
                    String email = (String) kakao.get("email");

                    MemberVO mvo = new MemberVO();
                    mvo.setEmail(email);
                    mvo.setNickname(nickname);
                    mvo.setP_img(p_img);

                    //이미 DB에 저장되어있던 사용자인지 판단하기

                    mv.addObject("mvo",mvo);
                    mv.setViewName("registry");

                }
            }//if의 끛

        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }
}
