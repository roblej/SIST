package ex1.vo;

public class TestVO {
    private String msg; // 외부에서 들어오려면 property 개념이 멤버변수다.

    public TestVO() {
        System.out.println("TestVO 생성");
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
