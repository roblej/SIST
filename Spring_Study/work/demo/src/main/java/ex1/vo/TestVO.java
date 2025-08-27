package ex1.vo;

public class TestVO {
    private String msg;

    public TestVO() {
        System.out.println("TestVO constructor");
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
