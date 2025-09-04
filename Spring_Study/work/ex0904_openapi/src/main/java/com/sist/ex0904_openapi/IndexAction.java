package com.sist.ex0904_openapi;

import com.sist.vo.DataVO;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class IndexAction{

    public String execute(HttpServletRequest request, HttpServletResponse response) {
        //공공데이터 openAPI를 호출하는 경로를 준비
        //https://apis.data.go.kr/B551011/KorService2/searchFestival2?serviceKey=UDJBx1JmLhMq4yX7YGUtpjM%2FYOHv10FbvzDZBc3QW1dZcPrMTAYg21rg3qsnwTv74tLvw7IA9CQELJB3AFnE9Q%3D%3D&MobileApp=AppTest&MobileOS=ETC&pageNo=1&numOfRows=100&eventStartDate=20250501&arrange=C&modifiedtime=&areaCode=1&_type=xml
        StringBuffer sb = new StringBuffer("http://apis.data.go.kr/B551011/KorService2/searchFestival2?");
        String key = "UDJBx1JmLhMq4yX7YGUtpjM%2FYOHv10FbvzDZBc3QW1dZcPrMTAYg21rg3qsnwTv74tLvw7IA9CQELJB3AFnE9Q%3D%3D&";
            String areaCode = null;
            String code = request.getParameter("areacode");
            String cPage = request.getParameter("cPage");
            String startDate = request.getParameter("startdate");

            if(cPage == null)
                cPage = "1";
            if(code == null)
                areaCode = "1";

            if(startDate == null){
            //20250725 이런식의 형식을 얻기 위해 형식 객체 필요
                SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
                Calendar now =  Calendar.getInstance();

                startDate = sf.format(now.getTime());
            }


            sb.append("serviceKey=");
            sb.append(key);
            sb.append("&MobileApp=AppTest");
            sb.append("&MobileOS=ETC");
            sb.append("&pageNo=");
            sb.append(cPage);
            sb.append("&numOfRows=100");
            sb.append("&eventStartDate=");
            sb.append(startDate);
            sb.append("&arrange=C&modifiedtime=&areaCode=1&_type=xml");

            try{
                //브라우저 창에서 경로(url)를 입력하고 요청하듯이 프로그램 상에서 요청할 때는 url 객체를 만들어야한다.
                URL url = new URL(sb.toString());
                //경로를 연결하는 객체
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                //응답 받을 데이터의 형식을 지정
                conn.setRequestProperty("Content-Type","application/xml");

                //연결 - 요청!
                conn.connect();

                //JDOM라이브러리에 있는 SAXBuilder를 통해 응답메세지를 XML문서화 시키기 위해 준비해야한다.
                SAXBuilder builder = new SAXBuilder();
                //응답되는 내용을 하나의 xml문서(Document)인식해야합니다.
                Document doc = builder.build(conn.getInputStream());
                Element root = doc.getRootElement();
//                System.out.println(root.getName()); //response

                //루트 안에 있는 body만 얻어낸다
                Element body = root.getChild("body");
                //body 안에 있는 items라는 요소를 얻어낸다.
                Element items = body.getChild("items");
                //itesm 안에 존재하는 모든 item이라는 자식요소들을 얻어낸다.
                List<Element> item_list = items.getChildren("item");

                System.out.println("Number of items received: " + item_list.size());

                //item들을 JSP에서 표현하기 위해 배열로 변환하여 request에 저장하려 한다.
                DataVO[] ar =  new DataVO[item_list.size()];
                int i=0;
                for(Element item : item_list){
                    String title = item.getChildText("title");
                    String addr1 = item.getChildText("addr1");
                    String addr2 = item.getChildText("addr2");
                    String firstimage =  item.getChildText("firstimage");
                    String firstimage2 =  item.getChildText("firstimage2");
                    String eventstartdate = item.getChildText("eventstartdate");
                    String eventenddate = item.getChildText("eventenddate");
                    String mapx = item.getChildText("mapx");
                    String mapy = item.getChildText("mapy");
                    String tel = item.getChildText("tel");

                    DataVO vo = new DataVO(title,mapx,mapy,addr1,addr2,firstimage,firstimage2,tel,eventstartdate,eventenddate);
                    ar[i++] = vo;

                }//for의 끝
                //배열에 모든 item들이 vo객체로 생성되어 저장된 상태. 배열을 jsp에서 표현할 수 있도록 request에 저장하자
                request.setAttribute("ar", ar);
            } catch (Exception e) {
                e.printStackTrace();
            }
        return "index.jsp";
    }
}
