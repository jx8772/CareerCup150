package chapter18;

/**
 * Problem: Imagine you have a square matrix, where each cell is either black (0) or white (1). Design an algorithm to find the maximum subsquare
 * such that all four borders are filled with black pixels
 * Created by xiangji on 9/18/14.
 */
public class Question11 {
    public static Subsquare findMaxSubsquare(int[][] matrix){
        int len = matrix.length;
        for(int size = len; size >= 1; size--){
            Subsquare square = findSubsquareWithSize(matrix, size);
            if(square != null){
                return square;
            }
        }
        return null;
    }

    public static Subsquare findSubsquareWithSize(int[][] matrix, int size){
        int bound = matrix.length - size;
        for(int row = 0; row <= bound; row++){
            for(int col = 0; col <= bound; col++){
                if(isSquare(matrix, row, col, size)){
                    return new Subsquare(row, col, size);
                }
            }
        }
        return null;
    }

    public static boolean isSquare(int[][] matrix, int row, int col, int size){
        //check top and bottom
        for(int i = 0; i < size; i++){
            if(matrix[row][col+i] == 1){
                return false;
            }
            if(matrix[row+size-1][col+i] == 1){
                return false;
            }
        }

        //check for left and right
        for(int i = 0; i < size; i++){
            if(matrix[row+i][col] == 1){
                return false;
            }
            if(matrix[row+i][col+size-1] == 1){
                return false;
            }
        }
        return true;
    }

}
