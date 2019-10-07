package bean;

import java.util.Date;

//收费员信息
public class TollCollectorInfo {
    public TollCollectorInfo() {

    }

    private String tollCollectorNo;		//收费员编号
    private String tollBoothNo;			//所属收费站编号
    private String laneNo;              //所属车道编号
    private String name;				//姓名
    private String sex;					//性别
    private String department;			//部门
    private String position;			//职位
    private String entryTime;			//入职时间
    private String phoneNo;             //电话
    private String email;               //邮箱
    private String homeAddress;         //家庭住址

    public String getTollCollectorNo() {
        return tollCollectorNo;
    }

    public void setTollCollectorNo(String tollCollectorNo) {
        this.tollCollectorNo = tollCollectorNo;
    }

    public String getTollBoothNo() {
        return tollBoothNo;
    }

    public void setTollBoothNo(String tollBoothNo) {
        this.tollBoothNo = tollBoothNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getLaneNo() {
        return laneNo;
    }

    public void setLaneNo(String laneNo) {
        this.laneNo = laneNo;
    }
}
