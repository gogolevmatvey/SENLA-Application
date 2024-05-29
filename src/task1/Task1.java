package task1;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        System.out.println(sumOfDigits(inputString));
    }

    private static int sumOfDigits(String inputString) {
        int sum = 0;
        for (int i = 0; i < inputString.length(); i++) {
            char character = inputString.charAt(i);
            if (Character.isDigit(character)) {
                sum += Character.getNumericValue(character);
            }
        }
        return sum;
    }
}
