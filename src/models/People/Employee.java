package models.People;

public class Employee extends People {
    private int employeeID;
    private String CPF;
    public Employee(String name, String phone, int employeeID, String CPF){
        super(name, phone);
        this.employeeID = employeeID;
        this.CPF = CPF;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
}
