package org.practice.problemsolving;

public class RotateImage {
    public void rotate(int[][] matrix) {
        for(int i=0; i < matrix.length / 2; i++) {
            int limit = matrix.length - i - 1;
            for(int j=i; j<limit; j++) {
                int tmp = matrix[j][limit];
                matrix[j][limit] = matrix[i][j];
                matrix[i][j] = matrix[limit-j][i];
                matrix[limit-j][i] = matrix[limit][limit-j];
                matrix[limit][limit-j] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4,5},{6,7,8, 9,10},{11,12,13,14,15},{16, 17,18,19,20} ,{21,22,23,24,25}};
        RotateImage obj = new RotateImage();
        obj.rotate(matrix);
    }
}
