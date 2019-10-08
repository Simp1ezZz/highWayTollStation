package bean;

import java.util.Date;

public class WorkLog {

    private String tollCollectorNo;         //收费员编号
    private String tollBooshNo;             //所属收费站编号
    private String startWorkTime;           //上班时间
    private String finishWorkTime;          //下班时间

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
