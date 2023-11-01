package karma.lab3.task6;

public class Circle extends Figure implements Movable {
    private int x;
    private int y;
    private int rad;

    public Circle(int x, int y, int rad) {
        this.x = x;
        this.y = y;
        this.rad = rad;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getrad() {
        return rad;
    }

    @Override
    public String getType() {
        return "Circle";
    }

    @Override
    public String toString() {
        return getType() + "(" + x + "," + y + "), (" + rad + "): ";
    }

    @Override
    public boolean contpoint(int x, int y) {
        var dx = x - this.x;
        var dy = y - this.y;
        return dx * dx + dy * dy <= this.rad * this.rad;
    }

    @Override
    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

}
