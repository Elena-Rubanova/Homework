import lesson7.*;


public class Main {
    public static void main(String[] args) {
        Dog dogBobik = new Dog("Бобик");
        Dog dogRex = new Dog("Рекс");
        Cat catBrus = new Cat("Брюс", false);
        Cat catIrbis = new Cat("Ирбис", true);

        dogBobik.run(600);
        dogBobik.swim(10);
        dogRex.run(400);
        dogRex.swim(15);

        catBrus.run(250);
        catBrus.swim(5);
        catIrbis.run(200);
        catIrbis.swim(0);

        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Мурзик", false);
        cats[1] = new Cat("Барсик", true);
        cats[2] = new Cat("Боня",  true);

        Bowl bowl = new Bowl(10);
        bowl.info();

        cats[0].eat(20);
        cats[1].eat(9);
        cats[2].eat(5);


        bowl.addFood(1);
        bowl.info();

        System.out.println("Количество собак: " + Dog.dogCount);
        System.out.println("Количество котов: " + Cat.catCount);
        System.out.println("Общее количество животных: " + (Dog.dogCount + Cat.catCount));

        System.out.println();
        System.out.println();

        Circle circle = new Circle(5);
        circle.setFillColor("Зеленый");
        circle.setBorderColor("Серый");
        circle.printCharacteristics();

        Rectangle rectangle = new Rectangle(5,9);
        rectangle.setFillColor("Розовый");
        rectangle.setBorderColor("Голубой");
        rectangle.printCharacteristics();

        Triangle triangle = new Triangle(7, 8, 9);
        triangle.setFillColor("Желтый");
        triangle.setBorderColor("Красный");
        triangle.printCharacteristics();


    }
}




