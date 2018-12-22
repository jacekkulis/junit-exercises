package pl.dmcs.demos;

public class Main {

    public static void main(String[] args) {
        Circle circle = new Circle(1, 1);

        System.out.println(circle);

        circle.moveCircle(circle, 23, 27);
        System.out.println(circle);
    }
}
