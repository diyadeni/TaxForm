public class Employee {

    private String empNum;
    private String empName;
    private String monthlyIncome;
    private String status;
    private String member;

    public Employee(String empNum, String empName, String monthlyIncome, String status, String member) {
        this.empNum = empNum;
        this.empName = empName;
        this.monthlyIncome = monthlyIncome;
        this.status = status;
        this.member = member;
    }

    public String getEmpNum() {
        return empNum;
    }

    public void setEmpNum(String empNum) {
        this.empNum = empNum;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(String monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }
}