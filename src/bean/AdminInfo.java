package bean;

public class AdminInfo {
    public AdminInfo(){

    }
    private String userName;
    private String passWord;
    private int tollCollecterNo;

    public int getTollCollecterNo() {
        return tollCollecterNo;
    }

    public void setTollCollecterNo(int tollCollecterNo) {
        this.tollCollecterNo = tollCollecterNo;
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
