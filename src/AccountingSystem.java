import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class AccountingSystem {
    private List<Employee> employees = new ArrayList<Employee>();
    private String fileName;

    public AccountingSystem(String fileName){
        this.fileName = fileName + ".dat";
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(this.fileName))){
        employees = (ArrayList<Employee>)objectInputStream.readObject();
            System.out.println("Файл " + fileName + " считан");

        }catch (Exception ex){
            System.out.println(ex);
        }

    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployees(Employee employees) {
        this.employees.add(employees);
    }

    public void saveData(){
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))){
        objectOutputStream.writeObject(employees);
        System.out.println("Файл " + fileName + " записан");

    }catch (Exception ex){
            System.out.println(ex);
            }
        }

    public void fireEmployee(int num){
        employees.remove(num);
    }


}
