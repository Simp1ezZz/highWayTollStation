package bean;
//子路段信息
public class RoadInfo {
    private String roadNo;	                    //子路段编号
    private String startTollBooshNo;			//起始站点编号
    private String endTollBooshNo;		        //终止站点编号
    private float roadMileage;                  //路段里程数

    public String getRoadNo() {
        return roadNo;
    }

    public void setRoadNo(String roadNo) {
        this.roadNo = roadNo;
    }

    public String getStartTollBooshNo() {
        return startTollBooshNo;
    }

    public void setStartTollBooshNo(String startTollBooshNo) {
        this.startTollBooshNo = startTollBooshNo;
    }

    public String getEndTollBooshNo() {
        return endTollBooshNo;
    }

    public void setEndTollBooshNo(String endTollBooshNo) {
        this.endTollBooshNo = endTollBooshNo;
    }

    public float getRoadMileage() {
        return roadMileage;
    }

    public void setRoadMileage(float roadMileage) {
        this.roadMileage = roadMileage;
    }
}
