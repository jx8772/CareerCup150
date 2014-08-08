package chapter1;

/**
 * Problem: Write an algorithm such that if an element in an M*N matrix is 0, its entire row and column are set to 0
 * Created by xiangji on 8/6/14.
 */
public class Question7 {
    public static void main(String[] args){
        int[][] matrix = {{2,3,0,4},{2,0,2,4},{2,3,1,4},{2,3,1,0}};
        setZeros(matrix);
    }

    public static void setZeros(int[][] matrix){
        if(matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        boolean rowHasZero = false, columnHasZero = false;
        //search if the first column has zero
        for(int i = 0; i < m; i++){
            if(matrix[i][0] == 0){
                columnHasZero = true;
                break;
            }
        }
        //search if the first row has zero
        for(int i = 0; i < n; i++){
            if(matrix[0][i] == 0){
                rowHasZero = true;
                break;
            }
        }
        //search the rest of matrix, if matrix[i][j] == 0, set matrix[i][0] = 0 and matrix[0][j] = 0
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        //nullify the rows and columns according to the flags in first row and first column
        //nullify the rows
        for(int i = 1; i < m; i++){
            if(matrix[i][0] == 0){
                for(int j = 1; j < n; j++){
                    matrix[i][j] = 0;
                }
            }
        }
        //nullify the columns
        for(int j = 1; j < n; j++){
            if(matrix[0][j] == 0){
                for(int i = 0; i < m; i++){
                    matrix[i][j] = 0;
                }
            }
        }
        //nullify the first row and first column, according to the columnHasZero and rowHasZero
        if(columnHasZero){
            for(int i = 0; i < m; i++){
                matrix[i][0] = 0;
            }
        }
        if(rowHasZero){
            for(int j = 0; j < n; j++){
                matrix[0][j] = 0;
            }
        }
    }

}
