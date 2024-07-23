import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class binarymatrix {
    //user input validation
    public static int takeintinp(String msg, Scanner sc){
        System.out.println(msg);
        int inp = 0;
        try{
            inp = sc.nextInt();
            if(inp < 0 || inp >1){
                System.out.println("Please enter a no between 0 and 1");
                inp = sc.nextInt();
            }

        }
        catch (Exception e){
            System.out.println("There was an error");
        }
        return inp;
    }
    public static int takeintinp1(String msg, Scanner sc){
        System.out.println(msg);
        int inp;
        try{
            inp = sc.nextInt();
        }
        catch (Exception e){
            System.out.println("There was an error");
            inp = takeintinp(msg,sc);
        }
        return inp;
    }
    static void printSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        int maxSize = 0;
        int maxRow = 0;
        int maxCol = 0;

        // Initialized the first row and column of dup matrix
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0];
            if (dp[i][0] > maxSize) {
                maxSize = dp[i][0];
                maxRow = i;
                maxCol = 0;
            }
        }

        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
            if (dp[0][j] > maxSize) {
                maxSize = dp[0][j];
                maxRow = 0;
                maxCol = j;
            }
        }

        // structuring the duplicate matrix
        System.out.println("Maximum submatrix with 1's");
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                    if (dp[i][j] > maxSize) {
                        maxSize = dp[i][j];
                        maxRow = i;
                        maxCol = j;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        // Print the maximum square submatrix with 1s
        if (maxSize > 0) {
            for (int i = maxRow; i > maxRow - maxSize; i--) {
                for (int j = maxCol; j > maxCol - maxSize; j--) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("No submatrix with 1s found.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = takeintinp1("Please enter the size of the matrix: ",sc);
        int m = takeintinp1("Pleae enter the size of the matrix: ",sc);
        int [][] matrix = new int[m][n];
        //take user input for each entry of the matrix using function takeintinp
        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = takeintinp("Please enter the no for pos"+i+","+j+":", sc);
            }
        }
        printSubmatrix(matrix);

    }
}
