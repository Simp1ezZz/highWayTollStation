package bean;

public class RechargeLog {
    private String time;                //充值时间
    private String cardNo;              //卡号
    private String tollCollectorNo;     //收费员编号
    private float rechargeAmount;       //充值金额

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getTollCollectorNo() {
        return tollCollectorNo;
    }

    public void setTollCollectorNo(String tollCollectorNo) {
        this.tollCollectorNo = tollCollectorNo;
    }

    public float getRechargeAmount() {
        return rechargeAmount;
    }

    public void setRechargeAmount(float rechargeAmount) {
        this.rechargeAmount = rechargeAmount;
    }
}
