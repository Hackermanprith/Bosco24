import java.util.Scanner;
import java.util.HashMap;

public class tower {
    // Input validation for integer input
    public static int takeIntInput(String msg, Scanner sc) {
        int inp = 0;
        System.out.println(msg);
        try {
            inp = sc.nextInt();
            if (inp < 0) {
                System.out.println("Please enter a number greater than or equal to 0");
                inp = takeIntInput(msg, sc);
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter an integer.");
            sc.next();  // clear the invalid input
            inp = takeIntInput(msg, sc);
        }
        return inp;
    }

    // Function to calculate the number of ways to arrange tiles
    public static int calculate(int n, int m, int k) {
        int[] dp = new int[n + 1];
        dp[0] = 1;  // There is one way to arrange 0 tiles (no tiles)

        // Iterate over each possible tile size
        for (int size = 1; size <= m; size++) {
            // Iterate over each possible number of tiles in reverse
            for (int i = n; i >= size; i--) {
                // Add ways by using 1, 2, ..., k tiles of the current size
                for (int j = 1; j <= k && j * size <= i; j++) {
                    dp[i] += dp[i - j * size];
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = takeIntInput("Enter the number of tiles: ", sc);
        int m = takeIntInput("Enter the maximum size of a tile: ", sc);
        int k = takeIntInput("Enter the maximum times a single tile size can be used: ", sc);

        int result = calculate(n, m, k);
        System.out.println("The number of ways to arrange the tiles is: " + result);
    }
}
