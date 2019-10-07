package bean;

public class TollBooshInfo {
    private String tollBooshNo;
    private String tollBooshName;
    private int numbersOfLane;
    private int totalTrafficVolume;
    private float totalTrafficTime;

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

    public int getTotalTrafficVolume() {
        return totalTrafficVolume;
    }

    public void setTotalTrafficVolume(int totalTrafficVolume) {
        this.totalTrafficVolume = totalTrafficVolume;
    }

    public float getTotalTrafficTime() {
        return totalTrafficTime;
    }

    public void setTotalTrafficTime(float totalTrafficTime) {
        this.totalTrafficTime = totalTrafficTime;
    }
}
