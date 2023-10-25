package src.Lab3.Taask6;

public class Annotation {
    private String label;
    private Figure figure;

    public Annotation(String label, Figure figure){
        this.label = label;//подпись
        this.figure = figure;//тип фигуры
    }
    
    public String getLabel() {
        return label;
    }

    public Figure getFigure() {
        return figure;
    }

    @Override
    public String toString() {
        return "Label: " + label + ", Figure: " + figure.toString();
    }
}
