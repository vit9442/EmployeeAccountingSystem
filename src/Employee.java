import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee implements Serializable {

    private String FIO;
    private Date birth;
    private String gender;
    private String phoneNumber;
    private String position;
    private Department department;

    private Date startDate;
    private double salary;
    private final SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    public Employee(String FIO, String gender, String phoneNumber, String position, Department department,String birth, double salary) {

        this.FIO = FIO;

        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.position = position;
        this.department = department;
        startDate = new Date();
        this.salary = salary;
        try {
            this.birth = formatter.parse(birth);
        } catch (Exception ex){
            System.out.println(ex);
        }

    }


    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }



    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getFIO() {
        return FIO;
    }

    public Date getBirth() {
        return birth;
    }

    public String getGender() {
        return gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPosition() {
        return position;
    }

    public Department getDepartment() {
        return department;
    }



    public Date getStartDate() {
        return startDate;
    }

    public double getSalary() {
        return salary;
    }


    @Override
    public String toString() {
        return "Сотрудник: {" +
                "ФИО='" + FIO + '\'' +
                ", Дата рождения=" + formatter.format(birth) +
                ", Пол='" + gender + '\'' +
                ", Телефон=" + phoneNumber +
                ", Должность='" + position + '\'' +
                ", отдел='" + department.getDepartmentName() + '\'' +
                ", Начальник='" + department.getDepartmentBoss() + '\'' +
                ", Дата начала работы=" + formatter.format(startDate) +
                ", зарплата=" + salary +"руб." +
                '}';
    }
}
