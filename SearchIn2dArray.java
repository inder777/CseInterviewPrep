package com.cip.main;

public class Search {
        public static boolean searchin2dMatrix(int[][] matrix, int x) {
            if(matrix.length == 0)
                return false;
            int row = matrix.length;
            int col = matrix[0].length;
            int i=0,j=col-1;
            while(i<row && j>=0){
                if(matrix[i][j] == x)
                    return true;
                else if(matrix[i][j]>x)
                    j--;
                else
                    i++;
            }
            return false;
        }

        public static void main(String[] s){
            int arr[][] = {{1,2,3},{4,5,6},{7,8,9}};
            System.out.println("==========Successful Search===========");
            System.out.println("search result "+searchin2dMatrix(arr,6));
            System.out.println("==========Unsuccessful Search===========");
            System.out.println("search result "+searchin2dMatrix(arr,10));
        }
    }
