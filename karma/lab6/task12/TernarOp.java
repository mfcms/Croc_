package karma.lab6.task12;
import java.util.function.Function;
import java.util.function.Predicate;

public class TernarOp {
    public static <T, R> R ternarOp(Predicate<T> predicate, Function<T, R> trueFunction, Function<T, R> falseFunction, T input) {
        return predicate.test(input) ? trueFunction.apply(input) : falseFunction.apply(input);
    }

}
