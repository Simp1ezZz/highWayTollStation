package bean;

public class TollBooshInfo {
    private String tollBooshNo;         //收费站编号
    private String tollBooshName;       //收费站名称
    private int numbersOfLane;          //收费站车道数

    public String getTollBooshNo() {
        return tollBooshNo;
    }

    public void setTollBooshNo(String tollBooshNo) {
        this.tollBooshNo = tollBooshNo;
    }

    public String getTollBooshName() {
        return tollBooshName;
    }

    public void setTollBooshName(String tollBooshName) {
        this.tollBooshName = tollBooshName;
    }

    public int getNumbersOfLane() {
        return numbersOfLane;
    }

    public void setNumbersOfLane(int numbersOfLane) {
        this.numbersOfLane = numbersOfLane;
    }

}
