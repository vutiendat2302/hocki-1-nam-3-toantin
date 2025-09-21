package week3;

public class Test {
    public static void main(String[] args) {

        Rectangle rec1 = new Rectangle(10.0, 5.0);
        Rectangle rec2 = new Rectangle(4.0, 6.0);

        System.out.println("Area : " + rec1.getArea());
        System.out.println("Compare rec1 to rec 2 : " + rec1.compareTo(rec2));
    }
}
