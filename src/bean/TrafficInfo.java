package bean;
//入站信息表
public class TrafficInfo {
    private String inSiteTollBooshNo;       //入站收费站编号
    private String inSiteTime;              //入站时间
    private String outSiteTollBooshNo;      //出站收费站编号
    private String outSiteTime;             //出站时间
    private String cardNo;                  //行车卡编号
    private float mileage;                  //里程数
    private float totalFee;                 //行程费用

    public String getInSiteTollBooshNo() {
        return inSiteTollBooshNo;
    }

    public void setInSiteTollBooshNo(String inSiteTollBooshNo) {
        this.inSiteTollBooshNo = inSiteTollBooshNo;
    }

    public String getInSiteTime() {
        return inSiteTime;
    }

    public void setInSiteTime(String inSiteTime) {
        this.inSiteTime = inSiteTime;
    }

    public String getOutSiteTollBooshNo() {
        return outSiteTollBooshNo;
    }

    public void setOutSiteTollBooshNo(String outSiteTollBooshNo) {
        this.outSiteTollBooshNo = outSiteTollBooshNo;
    }

    public String getOutSiteTime() {
        return outSiteTime;
    }

    public void setOutSiteTime(String outSiteTime) {
        this.outSiteTime = outSiteTime;
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
