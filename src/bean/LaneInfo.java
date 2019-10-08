package bean;

public class LaneInfo {
    private String laneNo;          //车道编号
    private String laneName;        //车道名称
    private String tollBooshNo;     //所属收费站编号
    private String principal;       //负责人

    public String getLaneNo() {
        return laneNo;
    }

    public void setLaneNo(String laneNo) {
        this.laneNo = laneNo;
    }

    public String getLaneName() {
        return laneName;
    }

    public void setLaneName(String laneName) {
        this.laneName = laneName;
    }

    public String getTollBooshNo() {
        return tollBooshNo;
    }

    public void setTollBooshNo(String tollBooshNo) {
        this.tollBooshNo = tollBooshNo;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

}
