package src.Lab2;
import java.util.Scanner;
//подсчёт арифметической суммы
public class Task4 {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);//ввод значений
        int a = console.nextInt();
        short b = console.nextShort();
        short n = console.nextShort();

        System.out.println("Sum: ");
        System.out.println(ArifmSumm(a,b,n));
    }
    
    public static long ArifmSumm(int a, short b, short n){//алгоритм для подсчёта арифметической суммы
        long sum = 0;
        for (int i = 2; i <= n+1; i++){
            sum += a;
            a += b;
        }
        return sum;
    }
}
