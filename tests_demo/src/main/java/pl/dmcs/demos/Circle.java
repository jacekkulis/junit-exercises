package pl.dmcs.demos;

public class Circle {
    private int x;
    private int y;

    public Circle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Circle moveCircle(Circle circle, int deltaX, int deltaY) {
        circle.setX(circle.getX() + deltaX);
        circle.setY(circle.getY() + deltaY);

        System.out.println("Inside: " + circle);

        circle = null;
        return circle;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Circle x=" + x + ", y=" + y;
    }
}
