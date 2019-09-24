package bean;
//收费员信息
public class TollCollecterInfo {
    public TollCollecterInfo() {

    }

    private String tollCollecterNo;		//收费员编号
    private String tollBoothNo;			//所属收费站编号
    private String name;				//姓名
    private String sex;					//性别
    private String department;			//部门
    private String position;			//职位
    private String entryTime;			//入职时间
    public String getTollCollecterNo() {
        return tollCollecterNo;
    }
    public void setTollCollecterNo(String tollCollecterNo) {
        this.tollCollecterNo = tollCollecterNo;
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


}
