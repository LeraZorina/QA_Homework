package shapes;

public interface GeometricFigures {
    default double perimeter(double... sideLength) {
        double result = 0.0;
        for (double v : sideLength) {
            result += v;
        }
        return result;
    }

    double area();
}
