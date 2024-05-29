package task4;

import java.util.Arrays;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        printNumber(number);
    }

    private static void printNumber(int number) {
        String[] stringDigits = String.valueOf(number).split("");
        int maxDigit = findMaxDigit(stringDigits);
        for (int i = 0; i < 5; i++) {
            for (String digit : stringDigits) {
                printDigit(Integer.parseInt(digit), maxDigit, i);
            }
            System.out.println();
        }
    }

    private static int findMaxDigit (String[]stringDigits) {
        int[] digits = new int[stringDigits.length];
        for (int i = 0; i < stringDigits.length; i++) {
            digits[i] = Integer.parseInt(stringDigits[i]);
        }
        Arrays.sort(digits);
        return digits[digits.length - 1];
    }

    private static void printDigit(int digit, int maxDigit, int line) {
        String[][] digitPatterns = {
                {" *** ", "*   *", "*   *", "*   *", " *** "},  // 0
                {"  *  ", " **  ", "  *  ", "  *  ", "*****"},  // 1
                {" *** ", "*   *", "  ** ", " *   ", "*****"},  // 2
                {"**** ", "    *", " *** ", "    *", "**** "},  // 3
                {"*   *", "*   *", "*****", "    *", "    *"},  // 4
                {"*****", "*    ", "**** ", "    *", "**** "},  // 5
                {" *** ", "*    ", "**** ", "*   *", " *** "},  // 6
                {"*****", "   * ", "  *  ", " *   ", "*    "},  // 7
                {" *** ", "*   *", " *** ", "*   *", " *** "},  // 8
                {" *** ", "*   *", " ****", "    *", " *** "}   // 9
        };

        String linePattern = digitPatterns[digit][line];
        if (digit == maxDigit)
            linePattern = linePattern.replace("*", String.valueOf(digit));

        System.out.print(linePattern + " ");
    }
}

