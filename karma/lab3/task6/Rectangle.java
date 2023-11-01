package karma.lab3.task6;

public class Rectangle extends Figure implements Movable {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Rectangle(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    @Override
    public String getType() {
        return "Rectangle";
    }

    @Override
    public String toString() {
        return getType() + " (" + x1 + "," + y1 + "), (" + x2 + "," + y2 + ")";
    }

    @Override
    public boolean containsPoint(int x, int y) {
        return (x >= x1) && (y >= y1) && (x <= x2) && (y >= y2);
    }

    @Override
    public void move(int dx, int dy) {
        x1 += dx;
        x2 += dx;
        y1 += dy;
        y2 += dy;
    }
}
