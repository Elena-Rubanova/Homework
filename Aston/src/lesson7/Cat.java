package lesson7;

public class Cat extends Animal {
    public static int catCount = 0;
    private final int maxRunLength = 200;
    public static boolean isHungry;



    public Cat(String name, boolean isHungry) {
        super(name);
        catCount++;
        this.isHungry = isHungry;

    }

    @Override
    public void run(int length) {
        if (length <= maxRunLength) {
            System.out.println(name + " пробежал " + length + " м.");
        } else {
            System.out.println(name + " не смог пробежать " + length + " м.");
        }
    }

    @Override
    public void swim(int length) {
        System.out.println(name + " не умеет плавать.");
        System.out.println();
    }


    public void eat(int foodAmount) {
        if (foodAmount <= 0) {
            System.out.println("Ошибка: Неверное количество еды");
        } else {
            if (!isHungry) {
                System.out.println(name + " не хочет есть, он уже сытый");
            } else {
                if (foodAmount >= 15) {
                    System.out.println(name + " нехватило еды в миске, он ее не трогает");
                } else {
                    isHungry = false;
                    System.out.println(name + " покушал и теперь не голоден");
                }
            }
        }
    }
}
