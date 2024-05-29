package task2;

import java.util.List;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            factorization(number);
        }
        else
            System.out.println("Ошибка: введеное число не целое или больше максимального значения int");
    }

    private static void factorization(int number) {
        if (number > 0) {
            for (int i = 2; i <= number; i++) {
                while (number % i == 0) {
                    System.out.println(i);
                    number /= i;
                }
            }
        }
        else
            System.out.println("Число меньше 1");
    }
}

