package com.sist.ex0903_kakaologin;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MapControl {


    private String req_url = "http://apis.data.go.kr/B551011/KorService2/";

    @RequestMapping("/map")
    public ModelAndView map() {
        ModelAndView mv = new ModelAndView();

        Map<String, Object> map = new HashMap<>();

        try {
            //연결된 서버로 파라미터들을 전달하기 위해 스트림 생성

            StringBuffer sb = new StringBuffer();
            sb.append("?serviceKey=UDJBx1JmLhMq4yX7YGUtpjM%2FYOHv10FbvzDZBc3QW1dZcPrMTAYg21rg3qsnwTv74tLvw7IA9CQELJB3AFnE9Q%3D%3D");
            sb.append("&numOfRows=10");
            sb.append("&pageNo=1&MobileOS=ETC&MobileApp=AppTest&_type=json");

            URL url = new URL(req_url+"areaCode2"+sb.toString());
            System.out.println(url.toString());
            //웹상의 경로와 연결하는 객체
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");

            int res_code = conn.getResponseCode();
            System.out.println("res_code = " + res_code);
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
                JSONParser parser = new JSONParser();
                JSONObject jsonObject = (JSONObject) parser.parse(res.toString());
                JSONObject response = (JSONObject) jsonObject.get("response");
                JSONObject body = (JSONObject) response.get("body");
                JSONObject items = (JSONObject) body.get("items");
                JSONArray itemArray = (JSONArray) items.get("item");

                for (Object o : itemArray) {
                    JSONObject item = (JSONObject) o;
                    String code = (String) item.get("code");
                    String name = (String) item.get("name");
                    map.put(code, name); // Map에 데이터 추가
                }

                System.out.println(map.toString());
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        mv.addObject("mvo", map);
        mv.setViewName("map");
        return mv;
    }

    @PostMapping("/area")
    @ResponseBody
    public Map<String, Object> area(String area) {
        Map<String, Object> responseMap = new HashMap<>();
        try {
            StringBuffer sb = new StringBuffer();
            sb.append("?serviceKey=UDJBx1JmLhMq4yX7YGUtpjM%2FYOHv10FbvzDZBc3QW1dZcPrMTAYg21rg3qsnwTv74tLvw7IA9CQELJB3AFnE9Q%3D%3D");
            sb.append("&MobileApp=AppTest&MobileOS=ETC&arrange=C&contentTypeId=12");
            sb.append("&areaCode=").append(area);
            sb.append("&numOfRows=20&pageNo=1&_type=json");

            URL url = new URL(req_url + "areaBasedList2" + sb.toString());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int res_code = conn.getResponseCode();
            if (res_code == 200) {
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuffer res = new StringBuffer();
                System.out.println(res.toString());
                String line;
                while ((line = br.readLine()) != null) {
                    res.append(line);
                }
                br.close();
                conn.disconnect();

                responseMap.put("data", res.toString());
                responseMap.put("status", "success");

            } else {
                responseMap.put("status", "error");
                responseMap.put("message", "API Error Code: " + res_code);
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseMap.put("status", "error");
            responseMap.put("message", e.getMessage());
        }
        return responseMap;
    }
}
