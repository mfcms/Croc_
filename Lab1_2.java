public class Lab1_2 {
    public static void main(String[] args){
        for (int i = 1; i < 100;i++){
            proverka(i);
        }
    }

    public static void proverka(int chis){
        if (chis%5==0 && chis%3==0){
            System.out.println("FizzBuss");
        }
        else if (chis%3==0){
            System.out.println("Fizz");
        }
        else if (chis%5==0){
            System.out.println("Buzz");
        }
        else {
            System.out.println(chis);
        }
    }
}