package com.djw.medium;

/**
 * @Author: dai jiawei
 * @Date: 2021/3/2 10:41
 */
public class NumMatrix {

    int[][] matrix;
    /**
     * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。
     * 上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。
     **/
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int length = matrix.length;
        int width= matrix[0].length;
         int result=0;
        for (int i = row1 ; i <= row2 ; i++) {
            for (int j = col1; j <= col2; j++) {
                result+=matrix[i][j];
            }
        }
        return result;
    }
}
