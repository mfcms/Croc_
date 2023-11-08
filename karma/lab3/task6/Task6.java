package karma.lab3.task6;

public class Task6 {
    public class Main {
        public static void main(String[] args) {
            AnnotatedImage example = new AnnotatedImage(
                    "null",
                    new Annotation(
                            "tree",
                            new Circle(2, 3, 5)),
                    new Annotation(
                            "Car",
                            new Rectangle(1, 2, 3, 4)));
            System.out.println(example.findByPoint(2, 3));
            System.out.println(example.findByLabel("ar"));

            if (example.findByLabel("Car").getFigure() instanceof Movable movable) {
                movable.move(10, 10);
            }
            
            System.out.println(example.findByLabel("ar"));
        }
    }
}
