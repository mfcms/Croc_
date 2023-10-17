package src.Lab1;
//Вывести числа от 1 до 100, вместо кратным 3 fizz, вместо кратным 5 buzz
public class Lab1_2 {
    public static void main(String[] args){
        for (int i = 1; i <= 100;i++){
            check(i);
        }
    }

    public static void check(int num){
        if (num%5==0 && num%3==0){
            System.out.println("FizzBuss");
        }
        else if (num%3==0){
            System.out.println("Fizz");
        }
        else if (num%5==0){
            System.out.println("Buzz");
        }
        else {
            System.out.println(num);
        }
    }
}