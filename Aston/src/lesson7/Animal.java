package lesson7;

public class Animal {
    public String name;

    public Animal(String name) {
        this.name = name;
    }

    public void run(int length) {
        System.out.println(name + " пробежал " + length + " м.");
    }

    public void swim(int length) {
        System.out.println(name + " проплыл " + length + " м.");
    }

}







