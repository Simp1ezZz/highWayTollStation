package bean;
//费率信息
public class FeeRateInfo {
    public FeeRateInfo() {

    }

    private String roadNo;	            //路段编号
    private String carType;             //车型
    private float fee;					//费率

    public String getRoadNo() {
        return roadNo;
    }

    public void setRoadNo(String roadNo) {
        this.roadNo = roadNo;
    }

    public float getFee() {
        return fee;
    }
    public void setFee(float fee) {
        this.fee = fee;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }
}
