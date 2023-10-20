package src.Lab2;
import java.util.Scanner;
//проверка на то, является ли число простым и является ли числ близнецом
public class Task3 {
    
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        long number = console.nextLong();

        if (isSimple(number) == true){
            System.out.println("Простое"); 

            if (isTwin(number) == true){//близнецами бывают только простые числа
            System.out.println("Близнец");
        }
        else {
            System.out.println("Не близнец");
        }
        }

        else {
            System.out.println("Составное");
        }
    }

    public static boolean isSimple(long number){
        //проверки при 1 нет потому что в условии число от 2
        for (int i = 2; i <= Math.sqrt(number); i++){ //проверка делителей до корня из числа
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isTwin(long number){
        if (number == 3){ //3 является близнецом
            return true;
        }
        else if (number == 2){ //2 не является
            return false;
        }//проверим остальное
        else if ((isSimple(number)==true) && ((isSimple(number+2)==true)|| (isSimple(number-2)==true))){
            return true;
        }
        else {
            return false;
        }
    }
}
