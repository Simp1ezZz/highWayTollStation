package bean;
//行车卡类
public class CardInfo {
    public CardInfo(){

    }

    private String cardNo;			//行车卡号
    private String drivingRecordNo;	//行车记录
    private String carType;		    //车型
    private String numberPlate;		//车牌号
    private String cardType;		//卡类型
    private float balance;			//余额
    private float usedFee;			//已使用费用


    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getDrivingRecordNo() {
        return drivingRecordNo;
    }

    public void setDrivingRecordNo(String drivingRecordNo) {
        this.drivingRecordNo = drivingRecordNo;
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

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
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
}
