package bean;
//费率信息
public class FeeRateInfo {
    public FeeRateInfo() {

    }

    private String siteCombinationNo;	//站点组合编号
    private String startSiteNo;			//起始站点编号
    private String endSiteNo;			//终止站点编号
    private int siteLenth;				//站点组合长度
    private int fee;					//费率

    public String getSiteCombinationNo() {
        return siteCombinationNo;
    }
    public void setSiteCombinationNo(String siteCombinationNo) {
        this.siteCombinationNo = siteCombinationNo;
    }
    public String getStartSiteNo() {
        return startSiteNo;
    }
    public void setStartSiteNo(String startSiteNo) {
        this.startSiteNo = startSiteNo;
    }
    public String getEndSiteNo() {
        return endSiteNo;
    }
    public void setEndSiteNo(String endSiteNo) {
        this.endSiteNo = endSiteNo;
    }
    public int getSiteLenth() {
        return siteLenth;
    }
    public void setSiteLenth(int siteLenth) {
        this.siteLenth = siteLenth;
    }
    public int getFee() {
        return fee;
    }
    public void setFee(int fee) {
        this.fee = fee;
    }


}
