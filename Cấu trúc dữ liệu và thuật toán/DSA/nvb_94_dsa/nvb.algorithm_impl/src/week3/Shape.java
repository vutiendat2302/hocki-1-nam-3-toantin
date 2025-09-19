package week3;

public interface Shape {
    public double getArea();
    public double getPerimeter();

    default int compareTo(Shape shape) {
        if (this.getArea() < shape.getArea()) {
            return -1;
        } else if (this.getArea() > shape.getArea()) {
            return 1;
        } else {
            return 0;
        }
    }
}
