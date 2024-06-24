package lesson7;

public class Dog extends Animal {
    public static int dogCount = 0;
    private final int maxRunLength = 500;
    private final int maxSwimLength = 10;

    public Dog(String name) {
        super(name);
        dogCount++;
    }

    public void run(int length) {
        if (length <= maxRunLength) {
            System.out.println(name + " пробежал " + length + " м.");
        } else {
            System.out.println(name + " не смог пробежать " + length + " м.");
        }
    }

    public void swim(int length) {
        if (length <= maxSwimLength) {
            System.out.println(name + " проплыл " + length + " м.");
        } else {
            System.out.println(name + " не смог проплыть " + length + " м.");
        }
        System.out.println();
    }
}



