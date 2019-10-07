package bean;

public class LaneInfo {
    private String laneNo;
    private String laneName;
    private String tollBooshNo;
    private String principal;
    private int trafficVolume;
    private float trafficTime;

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

    public int getTrafficVolume() {
        return trafficVolume;
    }

    public void setTrafficVolume(int trafficVolume) {
        this.trafficVolume = trafficVolume;
    }

    public float getTrafficTime() {
        return trafficTime;
    }

    public void setTrafficTime(float trafficTime) {
        this.trafficTime = trafficTime;
    }
}
