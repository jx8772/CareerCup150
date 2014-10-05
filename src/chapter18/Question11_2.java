package chapter18;

import CtCILibrary.AssortedMethods;

/**
 * Created by xiangji on 9/25/14.
 */
public class Question11_2 {
    public static void main(String[] args){
        int[][] matrix = AssortedMethods.randomMatrix(7, 7, 0, 1);
        AssortedMethods.printMatrix(matrix);
        Subsquare square = findMaxSubsquare(matrix);
        square.print();
    }

    public static Subsquare findMaxSubsquare(int[][] matrix){
        SquareCell[][] processed = preprocess(matrix);
        int len = matrix.length;
        for(int size = len; size >= 1; size--){
            Subsquare square = findSubsquareWithSize(processed, size);
            if(square != null){
                return square;
            }
        }
        return null;
    }

    public static Subsquare findSubsquareWithSize(SquareCell[][] matrix, int size){
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

    public static boolean isSquare(SquareCell[][] matrix, int row, int col, int size){
        SquareCell topLeft = matrix[row][col];
        SquareCell topRight = matrix[row][col+size-1];
        SquareCell bottomLeft = matrix[row+size-1][col];
        //check top edge
        if(topLeft.zerosRight < size){
            return false;
        }
        //check left edge
        if(topLeft.zerosBelow < size){
            return false;
        }
        //check right edge
        if(topRight.zerosBelow < size){
            return false;
        }
        //check bottom edge
        if(bottomLeft.zerosRight < size){
            return false;
        }
        return true;
    }

    public static SquareCell[][] preprocess(int[][] matrix){
        SquareCell[][] result = new SquareCell[matrix.length][matrix.length];
        for(int r = matrix.length-1; r >= 0; r--){
            for(int c = matrix.length-1; c >= 0; c--){
                int zerosRight = 0;
                int zerosBelow = 0;
                if(matrix[r][c] == 0){
                    zerosRight++;
                    zerosBelow++;
                    if(c < matrix.length-1){
                        SquareCell prev = result[r][c+1];
                        zerosRight += prev.zerosRight;
                    }
                    if(r < matrix.length-1){
                        SquareCell prev= result[r+1][c];
                        zerosBelow += prev.zerosBelow;
                    }
                }
                result[r][c] = new SquareCell(zerosRight, zerosBelow);
            }
        }
        return result;
    }
}
