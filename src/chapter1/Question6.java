package chapter1;

/**
 * Problem: Given an image represented by an N*N matrix, where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
 * Created by xiangji on 8/6/14.
 */
public class Question6 {
    public static void main(String[] args){
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix,3);
        return;
    }

    public static void rotate(int[][] matrix, int n){
        //transpose
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                //swap matrix[i][j] and matrix[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //interchange the columns: reflect the columns with the middle column as center
        int l = 0;
        int r = n-1;
        while(l < r){
            for(int i = 0; i < n; i++){
                //swap matrix[i][l] and matrix[i][r]
                int temp = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = temp;
            }
            l++;
            r--;
        }
    }
}
