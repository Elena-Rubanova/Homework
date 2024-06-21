package lesson6;

public class Park {
    private String name;
    private String location;
    private int numOfAttractions;

    public Park(String name, String location, int numOfAttractions) {
        this.name = name;
        this.location = location;
        this.numOfAttractions = numOfAttractions;
    }

    public void printParkInfo() {
        System.out.println("Название парка: " + name + "\n" + "Место нахождения: " + location + "\n" +
                "Количество атракционов: " + numOfAttractions);
        System.out.println();
    }

    public static class Attractions {
        // переменные-члены внутреннего класса
        private String attractionName;
        private String openingHours;
        private double cost;

        // конструктор внутреннего класса
        public Attractions(String attractionName, String openingHours, double cost) {
            this.attractionName = attractionName;
            this.openingHours = openingHours;
            this.cost = cost;
        }

        public String toString() {
            return String.format("Название атракциона: " + attractionName + "\n" + "Время работы: " + openingHours + "\n"
                    + "Стоимость: " + cost);

        }
    }
}
