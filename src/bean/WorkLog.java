package bean;

import java.util.Date;

public class WorkLog {

    private String tollCollectorNo;
    private String tollBooshNo;
    private String startWorkTime;
    private String finishWorkTime;

    public String getTollCollectorNo() {
        return tollCollectorNo;
    }

    public void setTollCollectorNo(String tollCollectorNo) {
        this.tollCollectorNo = tollCollectorNo;
    }

    public String getTollBooshNo() {
        return tollBooshNo;
    }

    public void setTollBooshNo(String tollBooshNo) {
        this.tollBooshNo = tollBooshNo;
    }

    public String getStartWorkTime() {
        return startWorkTime;
    }

    public void setStartWorkTime(String startWorkTime) {
        this.startWorkTime = startWorkTime;
    }

    public String getFinishWorkTime() {
        return finishWorkTime;
    }

    public void setFinishWorkTime(String finishWorkTime) {
        this.finishWorkTime = finishWorkTime;
    }
}
