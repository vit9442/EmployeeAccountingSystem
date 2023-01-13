import java.text.SimpleDateFormat;
import java.util.*;
import java.io.Serializable;
import java.util.stream.Collectors;

public class Program {

    public static void main(String[] args) {
        String fileName = "employees";
        int n;
        String login;
        String pass;
        AccountingSystem employee = null;
        do{
            login = null;
            pass = null;
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ " +
                "\n\t\t\tМеню" +
                "\n 1 - вход;" +
                "\n 2 - регистрация; " +
                "\n 0 - выход" +
                "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ");
        switch (n = new Scanner(System.in).nextInt()){
            case(1):
                System.out.println("Введите логин:");
                login = new Scanner(System.in).nextLine();
                System.out.println("Введите пароль:");
                pass = new Scanner(System.in).nextLine();
                employee = new AccountingSystem(fileName, login, pass);
                if (!employee.isLoged()){
                    employee = null;
                    System.out.println("неверный логин или пароль");

                }else n = 0;

                break;
            case (2):
                System.out.println("Введите логин:");
                login = new Scanner(System.in).nextLine();
                System.out.println("Введите пароль:");
                pass = new Scanner(System.in).nextLine();
                 employee = new AccountingSystem(fileName, login, pass);
                 if(employee.registration(login,pass)){
                     System.out.println("Пользователь зарегистрирован");
                 }else{ System.out.println("такое имя уже есть");employee=null;}
                 break;
            default:break;


        }
        }while (n != 0);






        Scanner scanner = new Scanner(System.in);


        n =0;
        if(employee != null && employee.isLoged())
        do {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ " +
                    "\n\t\t\tМеню" +
                    "\n 1 - добавить сотрудника;" +
                    "\n 2 - вывести сотрудников; " +
                    "\n 3 - добавить отдел; " +
                    "\n 4 - уволить сотрудника; " +
                    "\n 5 - изменить информацию о сотруднике;" +
                    "\n 6 - поиск сотрудника;" +
                    "\n 7 - Отчёты;" +
                    "\n 0 - выход" +
                    "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ");
            n = scanner.nextInt();
            switch (n) {
                case (1):
                    System.out.println("Введите ФИО:");
                    String FIO = new Scanner(System.in).nextLine();
                    System.out.println("Пол муж, жен:");
                    String gender = new Scanner(System.in).nextLine();
                    System.out.println("Введите номер телефона");
                    String number = new Scanner(System.in).nextLine();
                    System.out.println("Введите Должность:");
                    String position = new Scanner(System.in).nextLine();
                    System.out.println("Введите отдел:");
                    System.out.println("отделы:");
                    for (int i = 0; i < employee.getDepartments().size(); ++i) {
                        System.out.println(i + 1 + " " + employee.getDepartments().get(i).getDepartmentName());
                    }
                    System.out.println("выберите отдел, в который хотите поместить сотрудника " + FIO + " (1 - "
                            + employee.getDepartments().size() + ") ");
                    Department department = employee.getDepartments().get(new Scanner(System.in).nextInt() - 1);
                    System.out.println("Введите дату рождения в формате dd-mm-yyyy:");
                    String date = new Scanner(System.in).nextLine();
                    System.out.println("Введите зарплату");
                    double salary = new Scanner(System.in).nextDouble();
                    Employee emp = new Employee(FIO, gender, number, position, department, date, salary);
                    employee.addEmployees(emp);
                    System.out.println("Работник");
                    System.out.println(emp);
                    break;
                case (2):
                    System.out.println("Все сотрудники:");
                    int i = 1;
                    for (Employee e : employee.getEmployees()) {

                        System.out.println(i++ + " " + e);
                    }
                    break;
                case (3):
                    System.out.println("Введите название отдела:");
                    String departmentName = new Scanner(System.in).nextLine();
                    System.out.println("Введите ФИО начальника отдела:");
                    String departmentBoss = new Scanner(System.in).nextLine();
                    employee.addDepartment(new Department(departmentName, departmentBoss));
                    System.out.println("отдел добавлен");
                    break;
                case (4):
                    System.out.println("Введите номер сотрудника, которого нжно уволить:");
                    int num = new Scanner(System.in).nextInt();
                    employee.fireEmployee(num + 1);
                    break;
                case (5):// изменение
                    System.out.println("Введите номер сотрудника, которого нужно заменить:");
                    int numChange = new Scanner(System.in).nextInt();
                    System.out.println("Сотрудник:\n" + employee.getEmployees().get(numChange - 1));
                    System.out.println("Введите поле, которое нужно изменить:" +
                            "\n 1 - ФИО;" +
                            "\n 2 - телефон;" +
                            "\n 3 - должность; " +
                            "\n 4 - зарплата;"
                    );
                    int numRow = new Scanner(System.in).nextInt();
                    System.out.println("Введите новое значение:");
                    employee.EmployeeChange(numChange, numRow, new Scanner(System.in).nextLine());

                    System.out.println("Результат:\n" + employee.getEmployees().get(numChange - 1));
                    break;
                case (6):
                    System.out.println("Поиск сотрудника:\n 1 - по ФИО\n 2 - по должности" +
                            "\n 3 - по отделу \n 4 - по ФИО начальника");
                    n = 0;
                    n = scanner.nextInt();
                    switch (n) {
                        case (1):
                            System.out.println("Введите ФИО сотрудинка:");
                            String name = new Scanner(System.in).nextLine().toLowerCase();
                            List<Employee> empName = employee.searchByName(name);
                            for (Employee e : empName)
                                System.out.println(e);
                            break;
                        case (2):
                            System.out.println("Введите должность сотрудинка:");
                            String pos = new Scanner(System.in).nextLine().toLowerCase();
                            List<Employee> empPos = employee.searchByPosition(pos);
                            for (Employee e : empPos)
                                System.out.println(e);
                            break;
                        case (3):
                            System.out.println("Введите название отдела:");
                            String depName = new Scanner(System.in).nextLine().toLowerCase();
                            List<Employee> empDep = employee.searchByDepartment(depName);
                            System.out.println("Сотрудники в отделе " + depName);
                            for (Employee e : empDep) {
                                System.out.println(e);
                            }
                            break;
                        case (4):
                            System.out.println("Введите ФИО начальника:");
                            String bossName = new Scanner(System.in).nextLine().toLowerCase();
                            List<Employee> empBoss = employee.searchByBoss(bossName);
                            System.out.println("Сотрудники в подчинении у" + bossName);
                            for (Employee e : empBoss) {
                                System.out.println(e);

                            }
                            break;
                        default:
                            break;
                    }
                    break;
                case (7):


                    System.out.println("\t\t\tОтчёты" +
                            "\n 1 - Структура организации" +
                            "\n 2 - Средняя зарплата" +
                            "\n 3 - ТОП-10 самых дорогих сотрудников по зарплате" +
                            "\n 4 - ТОП-10 самых преданных сотрудников по количеству лет"
                    );
                    n = 0;
                    n = scanner.nextInt();
                    switch (n) {
                        case (1):
                            for (Department d : employee.getDepartments()) {
                                System.out.println(d);
                                List<Employee> empDep = employee.searchByDepartment(d.getDepartmentName());
                                System.out.println("Сотрудники в " + d.getDepartmentName());
                                for (Employee e : empDep) {
                                    System.out.println(e);
                                }
                            }
                            break;
                        case (2):
                            System.out.printf("%s %.2f\n", "Средняя зарплата всех сотрудников =", employee.averageSalary());
                            break;

                        case (3):
                            System.out.println("Топ-10 самых дорогих сотрудников по зарплате:");
                            List<Employee> empTopSalary = employee.topSalary(10);
                            for (Employee empTS : empTopSalary)
                                System.out.println(empTS);
                            break;

                        case (4):
                            System.out.println("Топ-10 самых дорогих сотрудников по зарплате:");
                            List<Employee> empTopDate = employee.topWorkingDate(10);
                            for (Employee empTS : empTopDate)
                                System.out.println(empTS);
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }
        } while (n != 0);
        if(employee != null && employee.isLoged())
        employee.saveData();


    }


}
