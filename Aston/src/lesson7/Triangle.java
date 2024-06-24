package lesson7;

public class Triangle implements Figure, FillColor, BorderColor {
    private double side1;
    private double side2;
    private double side3;
    private String fillColor;
    private String borderColor;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public double calculatePerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public double calculateArea() {
        double halfPerimeter = calculatePerimeter() / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - side1) *
                (halfPerimeter - side2) * (halfPerimeter - side3));
    }

    @Override
    public void setFillColor(String color){
        this.fillColor = color;
    }

    @Override
    public void setBorderColor(String color){
        this.borderColor = color;
    }

    public void printCharacteristics(){
        System.out.println("Треугольник: " + "\n"  + "Периметр: " + calculatePerimeter() + "\n"  + "Площадь: " + calculateArea() + "\n"
                + "Цвет фона: " + fillColor + "\n"  + "Цвет границ: " + borderColor);
    }
}

