package bean;

public class TotalFee {
    private String time;            //收款时间
    private String collectorNo;     //收费员编号
    private String cardNo;          //付款卡号
    private String carType;         //车型
    private String tollBooshNo;     //收费站编号、
    private String laneNo;          //车道编号
    private float fee;              //费用

    public String getCollectorNo() {
        return collectorNo;
    }

    public void setCollectorNo(String collectorNo) {
        this.collectorNo = collectorNo;
    }

    public String getTollBooshNo() {
        return tollBooshNo;
    }

    public void setTollBooshNo(String tollBooshNo) {
        this.tollBooshNo = tollBooshNo;
    }

    public String getLaneNo() {
        return laneNo;
    }

    public void setLaneNo(String laneNo) {
        this.laneNo = laneNo;
    }

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

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public float getFee() {
        return fee;
    }

    public void setFee(float fee) {
        this.fee = fee;
    }
}
