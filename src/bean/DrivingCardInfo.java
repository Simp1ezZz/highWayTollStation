package bean;
//行车卡类
public class DrivingCardInfo {
    public DrivingCardInfo(){

    }

    private String cardNo;			//行车卡号
    private String driverRecord;	//行车记录
    private String carMolde;		//车型
    private String carNo;			//车牌号
    private String cardMolde;		//卡类型
    private String balance;			//余额
    private String usedFee;			//已使用费用

    public String getCardNo() {
        return cardNo;
    }
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }
    public String getDriverRecord() {
        return driverRecord;
    }
    public void setDriverRecord(String driverRecord) {
        this.driverRecord = driverRecord;
    }
    public String getCarMolde() {
        return carMolde;
    }
    public void setCarMolde(String carMolde) {
        this.carMolde = carMolde;
    }
    public String getCarNo() {
        return carNo;
    }
    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }
    public String getCardMolde() {
        return cardMolde;
    }
    public void setCardMolde(String cardMolde) {
        this.cardMolde = cardMolde;
    }
    public String getBalance() {
        return balance;
    }
    public void setBalance(String balance) {
        this.balance = balance;
    }
    public String getUsedFee() {
        return usedFee;
    }
    public void setUsedFee(String usedFee) {
        this.usedFee = usedFee;
    }


}
