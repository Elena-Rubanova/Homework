import lesson6.Employee;
import lesson6.Park;


public class Main {
    public static void main(String[] args) {

        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Иванов Иван", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
        employees[1] = new Employee("Петров Петр", "QA", "petrov@mailbox.com", "892312314", 50000, 32);
        employees[2] = new Employee("Сидорова Анна", "AQA", "sidorova@mailbox.com", "892312315", 10000, 43);
        employees[3] = new Employee("Сазонова Дарья", "Developer", "sazonova@mailbox.com", "892312316", 5000, 18);
        employees[4] = new Employee("Жуковская Татьяна", "Project manager", "jukovskaya@mailbox.com", "892312317", 3000, 21);
        for (int i = 0; i < employees.length; i++) {

            employees[i].printEmployeeInfo();
        }
        {

            Park park = new Park("Гомельский парк атракционов", "г.Гомель", 20);
            park.printParkInfo();
            Park.Attractions attraction = new Park.Attractions("Колесо обозрения", "с 11.00 до 22.00", 20);
            attraction.printAttractionsInfo();
        }
    }
}


