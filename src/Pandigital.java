import java.math.BigInteger;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Pandigital {
    // Input validation for integer input
    public static int takeIntInput(String msg, Scanner sc) {
        int inp = 0;
        System.out.println(msg);
        try {
            inp = sc.nextInt();
            if (inp > 36 || inp < 0) {
                System.out.println("Please enter a number between 0 and 36:");
                inp = takeIntInput(msg, sc);
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Exiting.");
            System.exit(0);
        }
        return inp;
    }

    // Input validation for BigInteger input
    public static BigInteger takeBigIntInput(String msg, Scanner sc) {
        BigInteger inp;
        System.out.println(msg);
        try {
            inp = sc.nextBigInteger();
        } catch (Exception e) {
            System.out.println("Invalid input. Entering integer instead.");
            inp = BigInteger.valueOf(takeIntInput(msg, sc));
        }
        return inp;
    }

    public static boolean isPandigital(String number, int base) {
        Set<Character> digits = new HashSet<>();
        for (int i = 0; i < base; i++) {
            char digit = (i < 10) ? (char) ('0' + i) : (char) ('A' + i - 10);
            digits.add(digit);
        }

        for (char ch : number.toCharArray()) {
            if (digits.contains(ch)) {
                digits.remove(ch);
            } else {
                return false;
            }
        }

        return digits.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int base = takeIntInput("Please enter the base: ", sc);
        BigInteger number = takeBigIntInput("Please enter the number: ", sc);

        String valNumber = number.toString(base).toUpperCase();

        if (isPandigital(valNumber, base)) {
            System.out.println("It is a pandigital number.");
        } else {
            System.out.println("It is not a pandigital number.");
        }
    }
}
