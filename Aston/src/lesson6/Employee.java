package lesson6;

public class Employee {
    private String fullName;
    private String position;
    private String email;
    private int phone;
    private int salary;
    private int age;
    public Employee(String fullName, String position, String email, int phone, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }
    public void printEmployee() {
        System.out.println("ФИО: " + fullName);
        System.out.println("Должность: " + position);
        System.out.println("Email: " + email);
        System.out.println("Телефон: " + phone);
        System.out.println("Зарплата: " + salary);
        System.out.println("Возраст: " + age);

    }
    public static void main(String[] args) {
        Employee employee = new Employee("Смирнов Семен Семеныч", "Инженер",
                "smirnov@mail.ru", +123456789, 50000, 30);

        employee.printEmployee();

    }
}