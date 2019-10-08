package bean;
//出入站信息表
public class TrafficInfo {
    private String startTollBooshNo;        //入站收费站编号
    private String startLaneNo;             //入站车道编号
    private String startTime;               //入站时间
    private String endTollBooshNo;          //出站收费站编号
    private String endLaneNo;               //出站车道编号
    private String endTime;                 //出站时间
    private String cardNo;                  //行车卡编号
    private float mileage;                  //里程数
    private float totalFee;                 //行程费用

    public String getStartLaneNo() {
        return startLaneNo;
    }

    public void setStartLaneNo(String startLaneNo) {
        this.startLaneNo = startLaneNo;
    }

    public String getEndLaneNo() {
        return endLaneNo;
    }

    public void setEndLaneNo(String endLaneNo) {
        this.endLaneNo = endLaneNo;
    }

    public String getStartTollBooshNo() {
        return startTollBooshNo;
    }

    public void setStartTollBooshNo(String startTollBooshNo) {
        this.startTollBooshNo = startTollBooshNo;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTollBooshNo() {
        return endTollBooshNo;
    }

    public void setEndTollBooshNo(String endTollBooshNo) {
        this.endTollBooshNo = endTollBooshNo;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public float getMileage() {
        return mileage;
    }

    public void setMileage(float mileage) {
        this.mileage = mileage;
    }

    public float getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(float totalFee) {
        this.totalFee = totalFee;
    }
}
