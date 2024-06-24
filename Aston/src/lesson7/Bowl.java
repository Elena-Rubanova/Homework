package lesson7;

public class Bowl {
    private int foodAmount;

    public Bowl(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    public void addFood(int amount) {
        if (amount <= 0) {
            System.out.println("Ошибка: Неверное количество еды для добавления");
        } else {
            foodAmount += amount;
            System.out.println("Добавлено " + amount + " еды в миску");
        }
    }

    public void info() {
        System.out.println("Всего еды: " + foodAmount);
    }
}

