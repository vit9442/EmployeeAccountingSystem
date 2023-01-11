import java.text.SimpleDateFormat;
import java.util.*;
import java.io.Serializable;
import java.util.stream.Collectors;
public class Program {

    public static void main(String[] args) {
        String fileName = "employees";
        Scanner scanner = new Scanner(System.in);
        AccountingSystem employee = new AccountingSystem(fileName);
        int n;
        System.out.println(" 1 - добавить сотрудника; \n 2 - вывести сотрудников; \n 3 - уволить сотрудника; \n 4 - изменить информацию о сотрудника; \n 5 - поиск сотрудника.");
        while ((n = scanner.nextInt()) != 0)

        switch (n){
            case (1):
                System.out.println("Введите ФИО:");
                String FIO = new Scanner(System.in).nextLine();
                System.out.println("Пол муж, жен:");
                String gender = new Scanner(System.in).nextLine();
                System.out.println("Введите номер телефона");
                int number = new Scanner(System.in).nextInt();
                System.out.println("Введите Должность:");
                String position = new Scanner(System.in).nextLine();
                System.out.println("Введите отдел:");
                String department = new Scanner(System.in).nextLine();
                System.out.println("Начальник:");
                String boss = new Scanner(System.in).nextLine();
                System.out.println("Введите дату рождения в формате dd-mm-yyyy:");
                String date = new Scanner(System.in).nextLine();
                System.out.println("Введите зарплату");
                double salary = new Scanner(System.in).nextDouble();
                Employee emp = new Employee(FIO, gender,number,position, department, boss,date,salary );
                employee.addEmployees(emp);
                System.out.println("Работник");
                System.out.println(emp);
                break;
            case (2):
                System.out.println("Все сотрудники:");
                for (Employee e : employee.getEmployees())
                    System.out.println(e);
                break;

            case(3):
                System.out.println("Введите номер сотрудника, которого нжно уволить:");
                int num = new Scanner(System.in).nextInt();
                employee.fireEmployee(num + 1);
                break;
            case(4):// изменение
                System.out.println("Введите номер сотрудника, которого нужно заменить:");
                int numChange = new Scanner(System.in).nextInt();
                System.out.println("Сотрудник:\n" + employee.getEmployees().get(numChange - 1));
            case(5):
                System.out.println("Поиск сотрудника:\n 1 - по фамилии\n 2 - по должности" +
                        "\n 3 - по отделу \n 4 - по ФИО начальника");
                n = 0;
                n = scanner.nextInt();
                switch (n) {
                    case (1):
                        String name = new Scanner(System.in).nextLine().toLowerCase();
                        employee.getEmployees().stream()
                                .filter (a -> a.getFIO().toLowerCase().equals(name))
                                .forEach(System.out::println);
                        break;
                    case (2):
                        String pos = new Scanner(System.in).nextLine().toLowerCase();
                        employee.getEmployees().stream()
                                .filter (a -> a.getPosition().toLowerCase().equals(pos))
                                .forEach(System.out::println);
                        break;
                    case (3):
                        String dep = new Scanner(System.in).nextLine().toLowerCase();
                        employee.getEmployees().stream()
                                .filter (a -> a.getDepartment().toLowerCase().equals(dep))
                                .forEach(System.out::println);
                        break;
                    case (4):
                        String B = new Scanner(System.in).nextLine().toLowerCase();
                        employee.getEmployees().stream()
                                .filter (a -> a.getBoss().toLowerCase().equals(B))
                                .forEach(System.out::println);
                        break;
                    default: break;


                }

                break;
            default: break;
        }

        employee.saveData();



    }




}
