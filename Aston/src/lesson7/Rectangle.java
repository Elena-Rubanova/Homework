package lesson7;

public class Rectangle implements Figure, FillColor, BorderColor {
    private double width;
    private double height;
    private String fillColor;
    private String borderColor;

    public Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculatePerimeter(){
        return 2 * (width + height);
    }

    @Override
    public double calculateArea(){
        return width * height;
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
        System.out.println("Прямоугольник: " + "\n"  + "Периметр: " + calculatePerimeter() + "\n"  + "Площадь: " + calculateArea() + "\n"
                + "Цвет фона: " + fillColor + "\n"  + "Цвет границ: " + borderColor);
        System.out.println();
    }
}
