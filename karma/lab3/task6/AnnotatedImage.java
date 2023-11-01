package karma.lab3.task6;

public class AnnotatedImage {
    private final String imagePath;

    private final Annotation[] annotations;

    public AnnotatedImage(String imagePath, Annotation... annotations) {
        this.imagePath = imagePath;
        this.annotations = annotations;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public Annotation[] getAnnotations() {
        return this.annotations;
    }

    Annotation findByPoint(int x, int y) {
        for (Annotation annotation : annotations) {
            if (annotation.contpoint(x, y)) {
                return annotation;
            }
        }
        return null;
    }

    Annotation findByLabel(String label) {
        for (Annotation annotation : annotations) {
            if (annotation.contStr(label)) {
                return annotation;
            }
        }
        return null;
    }
}
