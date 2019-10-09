package bean;

public class TrafficVolume {
    private String tollBooshNo;     //收费站编号
    private String laneNo;          //车道编号
    private String carType;         //车型
    private int numbersOfPass;       //通行数量

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

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public int getNumbersOfPass() {
        return numbersOfPass;
    }

    public void setNumbersOfPass(int numberOfPass) {
        this.numbersOfPass = numberOfPass;
    }
}
