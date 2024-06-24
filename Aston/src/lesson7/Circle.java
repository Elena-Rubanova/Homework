package lesson7;

public class Circle implements Figure, FillColor, BorderColor {
    private double radius;
    private String fillColor;
    private String borderColor;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void setFillColor(String color) {
        this.fillColor = color;
    }

    @Override
    public void setBorderColor(String color) {
        this.borderColor = color;
    }
    public void printCharacteristics(){
        System.out.println("Круг: " + "\n"  + "Периметр: " + calculatePerimeter() + "\n"  + "Площадь: " + calculateArea() + "\n"
                + "Цвет фона: " + fillColor + "\n"  + "Цвет границ: " + borderColor);
        System.out.println();
    }
}