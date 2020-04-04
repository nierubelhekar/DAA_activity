import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static void matrixRotation(int[][] matrix, int m, int n, int r) {
        int layers = Math.min(m, n)/2;
        for(int l = 0; l < layers; l++) {
            int m_l = l+m-2*l;
            int n_l = l+n-2*l;
            int nbRotationsNeeded = (m_l-1-l)*2 + (n_l-1-l)*2;
            int boundedR = r % nbRotationsNeeded;
            if (boundedR == 0) continue;
            int rotationCount = 0;
            int i = l;
            int j = l;
            int current_first_i = i;
            int current_first_j = j;
            int current = matrix[i][j];
            while (rotationCount < nbRotationsNeeded) {
                int currentRotation = boundedR;
                while (currentRotation != 0) {
                    // go down
                    if (j == l && i<m_l-1) {
                        i++;
                    }
                    // go right
                    else if (i == m_l-1 && j<n_l-1) {
                        j++;
                    }
                    // go up
                    else if (j == n_l-1 && i>l) {
                        i--;
                    }
                    // go left
                    else if (i == l && j>l) {
                        j--;
                    }
                    currentRotation--;
                }
                int temp = matrix[i][j];
                matrix[i][j] = current;
                if (current_first_i == i && current_first_j == j) {
                    // go down
                    if (j == l && i<m_l-1) {
                        i++;
                    }
                    // go right
                    else if (i == m_l-1 && j<n_l-1) {
                        j++;
                    }
                    // go up
                    else if (j == n_l-1 && i>l) {
                        i--;
                    }
                    // go left
                    else if (i == l && j>l) {
                        j--;
                    }
                    current_first_i = i;
                    current_first_j = j;
                    temp = matrix[i][j];
                }
                current = temp;
                
               
                rotationCount++;
            }
        }
        
        // print
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int r = in.nextInt();
        int[][] matrix = new int[m][n];
        for(int matrix_i = 0; matrix_i < m; matrix_i++){
            for(int matrix_j = 0; matrix_j < n; matrix_j++){
                matrix[matrix_i][matrix_j] = in.nextInt();
            }
        }
        matrixRotation(matrix, m, n, r);
        in.close();
    }
}