import java.io.Serializable;
import java.util.List;

public class Department implements Serializable {
    private String departmentName;
    private String departmentBoss;


    private List<Employee> employeesInDepartment;
    public Department(String departmentName, String departmentBoss) {
        this.departmentName = departmentName;
        this.departmentBoss = departmentBoss;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getDepartmentBoss() {
        return departmentBoss;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setDepartmentBoss(String departmentBoss) {
        this.departmentBoss = departmentBoss;
    }

    public List<Employee> getEmployeesInDepartment() {
        return employeesInDepartment;
    }

    @Override
    public String toString() {
        return "Отдел: {" +
                 departmentName + '\'' +
                ",Начальник отдела " + departmentBoss + '\'' +
                '}';
    }
}
