package bean;

import java.util.Date;

//收费员信息
public class TollCollecterInfo {
    public TollCollecterInfo() {

    }

    private int tollCollecterNo;		//收费员编号
    private int tollBoothNo;			//所属收费站编号
    private String name;				//姓名
    private String sex;					//性别
    private String department;			//部门
    private String position;			//职位
    private Date entryTime;			    //入职时间
    private int phoneNo;                //电话
    private String email;               //邮箱
    private String homeAddress;         //家庭住址

    public int getTollCollecterNo() {
        return tollCollecterNo;
    }

    public void setTollCollecterNo(int tollCollecterNo) {
        this.tollCollecterNo = tollCollecterNo;
    }

    public int getTollBoothNo() {
        return tollBoothNo;
    }

    public void setTollBoothNo(int tollBoothNo) {
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

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
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
}
