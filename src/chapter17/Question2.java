package chapter17;

/**
 * Problem: Design an algorithm to figure out if someone has won a game of tic-tac-toe
 * Created by xiangji on 8/22/14.
 */
public class Question2 {
    public static void main(String[] args){
        char[][] board = {{'o', 'o', 'o'}, {'o', 'o', 'o'}, {'o', 'o', 'o'}};
        System.out.println(convertBoardToInt(board));
        System.out.println(hasWon(board));
    }

    public static char hasWon(char[][] board){
        int rows = 3;
        int cols = 3;
        if(board.length != 3 || board[0].length != 3){
            return ' ';
        }

        /*check the rows*/
        for(int i = 0; i < rows; i++){
            if(board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]){
                return board[i][0]; //return the winner symbol
            }
        }

        /*check the columns*/
        for(int i = 0; i < cols; i++){
            if(board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i]){
                return board[0][i];
            }
        }

        /*check the diagonal*/
        if(board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]){
            return board[0][0];
        }

        /*check the reverse diagonal*/
        if(board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]){
            return board[0][2];
        }

        return ' ';
    }

    /*convert the board into a base-3 number*/
    public static int convertBoardToInt(char[][] board){
        int rows = 3;
        int cols = 3;
        int sum = 0;
        int factor = 0;
        if(board.length != 3 || board[0].length != 3){
            return ' ';
        }
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                int digit;
                if(board[i][j] == ' '){
                    digit = 0;
                }
                else if(board[i][j] == 'x'){
                    digit = 1;
                }
                else{
                    digit = 2;
                }
                sum += Math.pow(3,factor++)*digit;
            }
        }
        return sum;
    }
}
