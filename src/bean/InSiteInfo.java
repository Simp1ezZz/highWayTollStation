package bean;
//入站信息
public class InSiteInfo {
    public InSiteInfo() {

    }

    private String tollBoothNo;			//收费站编号
    private String position;			//位置
    private String affiliatedRode;		//所属路段
    private int numberOfLanes;			//车道数量

    public String getTollBoothNo() {
        return tollBoothNo;
    }
    public void setTollBoothNo(String tollBoothNo) {
        this.tollBoothNo = tollBoothNo;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public String getAffiliatedRode() {
        return affiliatedRode;
    }
    public void setAffiliatedRode(String affiliatedRode) {
        this.affiliatedRode = affiliatedRode;
    }
    public int getNumberOfLanes() {
        return numberOfLanes;
    }
    public void setNumberOfLanes(int numberOfLanes) {
        this.numberOfLanes = numberOfLanes;
    }


}
