import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee implements Serializable {

    private String FIO;
    private Date birth;
    private String gender;
    private int phoneNumber;
    private String position;
    private String department;
    private String boss;
    private Date startDate;
    private double salary;
    private final SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    public Employee(String FIO, String gender, int phoneNumber, String position, String department, String boss,String birth, double salary) {

        this.FIO = FIO;

        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.position = position;
        this.department = department;
        this.boss = boss;
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

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setBoss(String boss) {
        this.boss = boss;
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

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getPosition() {
        return position;
    }

    public String getDepartment() {
        return department;
    }

    public String getBoss() {
        return boss;
    }

    public Date getStartDate() {
        return startDate;
    }

    public double getSalary() {
        return salary;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "ФИО='" + FIO + '\'' +
                ", Дата рождения=" + formatter.format(birth) +
                ", Пол='" + gender + '\'' +
                ", Телефон=" + phoneNumber +
                ", Должность='" + position + '\'' +
                ", отдел='" + department + '\'' +
                ", Начальник='" + boss + '\'' +
                ", Дата начала работы=" + formatter.format(startDate) +
                ", зарплата=" + salary +"руб." +
                '}';
    }
}
