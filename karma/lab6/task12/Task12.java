package karma.lab6.task12;
import java.util.function.Function;
import java.util.function.Predicate;

public class Task12 extends TernarOp {
    public static void main(String[] args) {
        // Примеры использования метода ternaryOperator

        //является ли число положительным
        Predicate<Integer> isPositive = n -> n > 0;
        Function<Integer, String> positiveMessage = n -> "Число " + n + " положительное";
        Function<Integer, String> negativeMessage = n -> "Число " + n + " отрицательное или равно нулю";

        int number1 = 5;
        String result1 = ternarOp(isPositive, positiveMessage, negativeMessage, number1);
        System.out.println(result1);

        // является ли строка пустой
        Predicate<String> isEmpty = String::isEmpty;
        Function<String, Integer> emptyLength = String::length;
        Function<String, Integer> nonEmptyLength = String::length;

        String emptyString = "";
        int result3 = ternarOp(isEmpty, emptyLength, nonEmptyLength, emptyString);
        System.out.println(result3);

        String nonEmptyString = "Hello, World!";
        int result4 = ternarOp(isEmpty, emptyLength, nonEmptyLength, nonEmptyString);
        System.out.println(result4);
    }
}
