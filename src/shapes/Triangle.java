package shapes;

public class Triangle implements GeometricFigures, ShapesWithBorders, FilledShapes {
    private final double a;
    private final double b;
    private final double c;
    private String fillColor;
    private String borderColor;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /*@Override
    public double perimeter() {
        return a + b + c;
    }*/

    @Override
    public double area() {
        double halfPerimeter = (a + b + c) / 2.0;
        return Math.sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c));
    }

    @Override
    public void setFill(String fillColor) {
        this.fillColor = fillColor;
    }

    @Override
    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public void infoTriangle() {
        System.out.println("Треугольник со сторонами: а=" + a + ", b= " + b + ", c=" + c + " \nПериметр: " + perimeter(a,b,c) + "\nПлощадь: " + area() +
                "\nЦвет границы: " + borderColor + "\nЦвет заливки: " + fillColor);
    }
}
