package bean;

public class AdminInfo {
    public AdminInfo(){

    }
    private String userName;
    private String passWord;
    private String tollCollectorNo;

    public String getTollCollectorNo() {
        return tollCollectorNo;
    }

    public void setTollCollectorNo(String tollCollectorNo) {
        this.tollCollectorNo = tollCollectorNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
