package lesson6;

public class Employee {
    private String FIO;
    private String position;
    private String email;
    private String phone;
    private double salary;
    private int age;

    public Employee(String FIO, String position, String email, String phone, double salary, int age) {
        this.FIO = FIO;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void printEmployeeInfo() {
        System.out.println("ФИО: " + FIO + "\n" + "Должность: " + position + "\n" + "Email: " + email + "\n" +
                "Телефон: " + phone + "\n" + "Зарплата: " + salary + "\n" + "Возраст: " + age);
        System.out.println();

    }
}