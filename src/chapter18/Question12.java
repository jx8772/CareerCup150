package chapter18;
import CtCILibrary.AssortedMethods;

/**
 * Problem: Given an N*N matrix of positive and negative integers, write code to find the submatrix with largest possible sum
 * Created by xiangji on 9/25/14.
 */
public class Question12 {
    public static void main(String[] args) {
        int[][] matrix = AssortedMethods.randomMatrix(10, 10, -5, 5);
        AssortedMethods.printMatrix(matrix);
        System.out.println(getMaxMatrix(matrix));
    }

    public static int getMaxMatrix(int[][] matrix){
        int max = Integer.MIN_VALUE;
        int[][] sumMatrix = preprocess(matrix);
        for(int row1 = 0; row1 < sumMatrix.length; row1++){
            for(int row2 = row1; row2 < sumMatrix.length; row2++){
                for(int col1 = 0; col1 < sumMatrix.length; col1++){
                    for(int col2 = col1; col2 < sumMatrix.length; col2++){
                        max = Math.max(computeSum(sumMatrix, row1, row2, col1, col2), max);
                    }
                }
            }
        }
        return max;
    }

    public static int[][] preprocess(int[][] matrix){
        int[][] sumMatrix = new int[matrix.length][matrix.length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                if(i == 0 && j == 0){
                    sumMatrix[i][j] = matrix[i][j];
                }
                else if(i == 0){
                    sumMatrix[i][j] = sumMatrix[i][j-1] + matrix[i][j];
                }
                else if(j == 0){
                    sumMatrix[i][j] = sumMatrix[i-1][j] + matrix[i][j];
                }
                else{
                    sumMatrix[i][j] = sumMatrix[i][j-1] + sumMatrix[i-1][j] - sumMatrix[i-1][j-1] + matrix[i][j];
                }
            }
        }
        return sumMatrix;
    }

    public static int computeSum(int[][] sumMatrix, int i1, int i2, int j1, int j2){
        if(i1 == 0 && j1 == 0){
            return sumMatrix[i2][j2];
        }
        else if(i1 == 0){
            return sumMatrix[i2][j2] - sumMatrix[i2][j1-1];
        }
        else if(j1 == 0){
            return sumMatrix[i2][j2] - sumMatrix[i2-1][j2];
        }
        else{
            return sumMatrix[i2][j2] - sumMatrix[i2][j1-1] - sumMatrix[i1-1][j2] + sumMatrix[i1-1][j1-1];
        }
    }
}
