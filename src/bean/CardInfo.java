package bean;
//行车卡类
public class CardInfo {
    public CardInfo(){

    }

    private String cardNo;			        //行车卡号
    private String carType;		            //车型
    private String numberPlate;		        //车牌号
    private String cardIssueTollBooshNo;    //发卡收费站编号
    private String cardIssueTollCollectorNo;//发卡收费员编号
    private float balance;			        //余额
    private float usedFee;			        //已使用费用
    private String phone;                   //办理人手机号
    private String name;                    //办理人姓名
    private String time;                    //办理时间

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public float getUsedFee() {
        return usedFee;
    }

    public void setUsedFee(float usedFee) {
        this.usedFee = usedFee;
    }

    public String getCardIssueTollBooshNo() {
        return cardIssueTollBooshNo;
    }

    public void setCardIssueTollBooshNo(String cardIssueTollBooshNo) {
        this.cardIssueTollBooshNo = cardIssueTollBooshNo;
    }

    public String getCardIssueTollCollectorNo() {
        return cardIssueTollCollectorNo;
    }

    public void setCardIssueTollCollectorNo(String cardIssueTollCollectorNo) {
        this.cardIssueTollCollectorNo = cardIssueTollCollectorNo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
