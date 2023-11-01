package karma.lab3.task6;

public class Annotation {
    private String label;
    private Figure figure;

    public Annotation(String label, Figure figure) {
        this.label = label;// подпись
        this.figure = figure;// тип фигуры
    }

    public String getLabel() {
        return label;
    }

    public Figure getFigure() {
        return figure;
    }

    public boolean containsPoint(int x, int y) {
        return figure.containsPoint(x, y);
    }

    @Override
    public String toString() {
        return figure.toString() + ": " + label;
    }
}
