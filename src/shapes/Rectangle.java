package shapes;

public class Rectangle implements GeometricFigures, ShapesWithBorders, FilledShapes {
    private final double a;
    private final double b;
    private String fillColor;
    private String borderColor;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double perimeter() {
        return 2.0 * (a + b);
    }

    @Override
    public double area() {
        return a * b;
    }

    @Override
    public void setFill(String fillColor) {
        this.fillColor = fillColor;
    }

    @Override
    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public void infoRectangle() {
        System.out.println("Прямоугольник со сторонами: a=" + a + ", b=" + b + " \nПериметр: " + perimeter() + "\nПлощадь: " + area() +
                "\nЦвет границы: " + borderColor + "\nЦвет заливки: " + fillColor);
    }
}
