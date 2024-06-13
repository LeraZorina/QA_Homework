package shapes;

public class Circle implements GeometricFigures, FilledShapes, ShapesWithBorders {
    private final double r;
    private String fillColor;
    private String borderColor;

    public Circle(double r) {
        this.r = r;
    }

    @Override
    public double perimeter(double ... sideLength) {
        return 2.0 * Math.PI * r;
    }

    @Override
    public double area() {
        return Math.PI * r * r;
    }

    @Override
    public void setFill(String fillColor) {
        this.fillColor = fillColor;
    }

    @Override
    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public void infoCircle() {
        System.out.println("Круг c радиусом " + r + " \nПериметр: " + perimeter(r) + "\nПлощадь: " + area() +
                "\nЦвет границы: " + borderColor + "\nЦвет заливки: " + fillColor);
    }
}
