package chapter9;
import java.util.ArrayList;

/**
 * Problem: Write an algorithm to print all ways of arranging eight queens on an 8*8 chess board so that none of them share the same row, column, or diagonal.
 * Created by xiangji on 9/29/14.
 */
public class Question9 {
    private static int GRID_SIZE = 8;

    public static void main(String[] args){
        ArrayList<Integer[]> res = new ArrayList<Integer[]>();
        Integer[] columns = new Integer[GRID_SIZE];
        placeQueens(0, columns, res);
        return;
    }

    public static void placeQueens(int row, Integer[] columnForRow, ArrayList<Integer[]> res){
        if(row == GRID_SIZE){
            res.add(columnForRow.clone());
            return;
        }
        for(int col = 0; col < GRID_SIZE; col++){
            if(isValid(columnForRow, row, col)){
                columnForRow[row] = col;
                placeQueens(row+1, columnForRow, res);
            }
        }
    }

    /*check if the position (row,col) is valid*/
    public static boolean isValid(Integer[] columns, int row, int col){
        for(int row2 = 0; row2 < row; row2++){
            int col2 = columns[row2];

            //check if they are in same column
            if(col == col2){
                return false;
            }

            //check if they are in same diagonal
            int colDist = Math.abs(col - col2);
            int rowDist = row - row2;
            if(colDist == rowDist){
                return false;
            }
        }
        return true;
    }
}
