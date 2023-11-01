package karma.lab3.task6;

public class Circle extends Figure implements Movable {
    private int x;
    private int y;
    private int radius;

    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public String getType() {
        return "Circle";
    }

    @Override
    public String toString() {
        return getType() + " (" + x + "," + y + "), (" + radius + ")";
    }

    @Override
    public boolean containsPoint(int x, int y) {
        var dx = x - this.x;
        var dy = y - this.y;
        return dx * dx + dy * dy <= this.radius * this.radius;
    }

    @Override
    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }
}
