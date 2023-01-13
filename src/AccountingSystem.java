import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class AccountingSystem {
    private List<Employee> employees;
    private List<Department> departments;
    private List<User> user;
    private String fileName;
    private transient boolean loged =false;



    public AccountingSystem(String fileName, String login, String pass){
        user = new ArrayList<User>();
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("user.dat"))){
            user = (ArrayList<User>)objectInputStream.readObject();


        }catch (Exception ex){
            System.out.println(ex);
        }

        if(logIn(login, pass)) {
            departments = new ArrayList<Department>();
            employees = new ArrayList<Employee>();
            this.fileName = fileName + ".dat";
            try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(this.fileName))) {
                employees = (ArrayList<Employee>) objectInputStream.readObject();
                System.out.println("Файл " + fileName + " считан");

            } catch (Exception ex) {
                System.out.println(ex);
            }
            try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Departments.dat"))) {
                departments = (ArrayList<Department>) objectInputStream.readObject();


            } catch (Exception ex) {
                System.out.println(ex);
            }
            loged = true;
        }
    }

public boolean registration(String login, String pass){
    try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("user.dat"))){
        user = (ArrayList<User>)objectInputStream.readObject();
        if(user.size()>0) {
        for (User u: user) {
        if(u.getLogin().equals(login)) return false;

        }
        user.add(new User(login, pass));
        userSave();
        return true;
        }


    }  catch(Exception e){ try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("user.dat"))){
        if (user == null) user = new ArrayList<User>();
        user.add(new User(login,pass));
        objectOutputStream.writeObject(user);
        userSave();
        return true;

    }catch (Exception ex){
        System.out.println(ex);return false;}

    }
    userSave();
    return true;

}

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void addEmployees(Employee employees) {
        this.employees.add(employees);
    }
    public void addDepartment(Department department) {
        this.departments.add(department);
    }
    public void saveData(){
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))){
        objectOutputStream.writeObject(employees);
        System.out.println("Файл " + fileName + " записан");

    }catch (Exception ex){
            System.out.println(ex);
            }
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Departments.dat"))){
            objectOutputStream.writeObject(departments);
            System.out.println("Файл " + "Departments.dat" + " записан");

        }catch (Exception ex){
            System.out.println(ex);
        }
        userSave();


        }
    public boolean isLoged() {
        return loged;
    }

    public void fireEmployee(int num){
        employees.remove(num);
    }
    public void EmployeeChange(int n, int e, Object o){

        switch (e){
            case(1):

                employees.get(n - 1).setFIO((String) o);
                break;
            case(2):

                employees.get(n - 1).setPhoneNumber((String) o);
                break;
            case(3):

                employees.get(n- 1).setPosition((String) o);
                break;
            case(4):

                employees.get(n - 1).setSalary(Double.parseDouble((String) o));
                break;
            default:
                ;break;

        }
   ;
    }


    public List<Employee> searchByName(String s){
         List<Employee> emp = employees.stream()
                .filter (a -> a.getFIO().toLowerCase().equals(s))
                 .collect(Collectors.toList());
        return emp;
    }

    public List<Employee> searchByPosition(String s){
        List<Employee> emp = employees.stream()
                .filter (a -> a.getPosition().toLowerCase().equals(s))
                .collect(Collectors.toList());
        return emp;
    }
    public List<Employee> searchByDepartment(String s){
        List<Employee> emp = employees.stream()
                .filter (a -> a.getDepartment().getDepartmentName().toLowerCase().equals(s))
                .collect(Collectors.toList());
        return emp;
    }


    public List<Employee> searchByBoss(String s){
        List<Employee> emp = employees.stream()
                .filter (a -> a.getDepartment().getDepartmentBoss().toLowerCase().equals(s))
                .collect(Collectors.toList());
        return emp;
    }

    public List<Employee> topSalary(int n){
        List<Employee> res = new ArrayList<Employee>();
        res = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .limit(n)
                .collect(Collectors.toList());
        return res;
    }

    public List<Employee> topWorkingDate(int n){
        List<Employee> res = new ArrayList<Employee>();
        res = employees.stream()
                .sorted(Comparator.comparing(Employee::getStartDate))
                .limit(n)
                .collect(Collectors.toList());
        return res;
    }

    public double averageSalary(){
        double stat =  employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .getAsDouble();
         return stat;

    }

    public boolean addUser(String login, String pass) {
        if (!user.contains(login)) {
            user.add(new User(login, pass));
            return true;
        }
        return false;
    }

    private boolean logIn(String login, String pass){
     if(user.size() > 0){
         for (User u: user){
             if(u.getLogin().equals(login) && u.getPassword().equals(pass)){
                 return true;

             }
         }

     }
        return false;
    }
    private void userSave() {
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("user.dat"))){
            objectOutputStream.writeObject(user);


        }catch (Exception ex){
            System.out.println(ex);
        }
}
}
