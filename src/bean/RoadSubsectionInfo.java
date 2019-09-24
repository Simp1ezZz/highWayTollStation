package bean;
//子路段信息
public class RoadSubsectionInfo {
    public RoadSubsectionInfo() {

    }

    private String roadSubsectionNo;	//子路段编号
    private String startSiteNo;			//起始站点编号
    private String endSiteNo;			//终止站点编号
    private String recentSiteNo;		//最近站点编号
    private String adjacentSiteNo;		//相邻站点编号
    private String ownerNo;				//业主编号
    private String roadFee;				//道路费用
    public String getRoadSubsectionNo() {
        return roadSubsectionNo;
    }
    public void setRoadSubsectionNo(String roadSubsectionNo) {
        this.roadSubsectionNo = roadSubsectionNo;
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
    public String getRecentSiteNo() {
        return recentSiteNo;
    }
    public void setRecentSiteNo(String recentSiteNo) {
        this.recentSiteNo = recentSiteNo;
    }
    public String getAdjacentSiteNo() {
        return adjacentSiteNo;
    }
    public void setAdjacentSiteNo(String adjacentSiteNo) {
        this.adjacentSiteNo = adjacentSiteNo;
    }
    public String getOwnerNo() {
        return ownerNo;
    }
    public void setOwnerNo(String ownerNo) {
        this.ownerNo = ownerNo;
    }
    public String getRoadFee() {
        return roadFee;
    }
    public void setRoadFee(String roadFee) {
        this.roadFee = roadFee;
    }


}
