package Com.sangram.DSA.Com.Dsa.Arrays;

import java.util.HashSet;

public class Matrix {

   /*
    * ================================================================
    * 🧠 PROBLEM:
    * ================================================================
    *
    * Author : Sangram Chavanpatil
    * Date   : 2026-05-02
    *
    * ------------------------------------------------
    * 📌 Problem Statement: Question 2 — Transpose a Matrix 🟢
Input:         Output:
1  2  3        1  4  7
4  5  6   →    2  5  8
7  8  9        3  6  9
    *
    *
    * ------------------------------------------------
    * 💡 Approach:
    *
    *      original(row*col)                 transpose(cols*rows)
    *       (0,0)  (0,1)     (0,2)             (0,0)  (1,0)
    *       {1,      2,       3}                {1,   4 }
            (1,0)   (1,1)   (1,2)              (0,1)  (1,1)
            {4,      5,       6}                {2,    5}
                                                (0,2)  (1,2)
   *                                            {3,    6}
    *
    *
    *
    *       transpose[columns][rows] = Original[rows][columns];
    * ------------------------------------------------
    * ⏱ Time Complexity  :
    * 🗂 Space Complexity :
    *
    * ------------------------------------------------
    * 📝 Notes:
    *
    * ================================================================
    */

//  Transpose of matrix
    public static int[][] printmatrix(int[][] arr) {
        int rows = arr.length;
        int clos = arr[0].length;

        int[] row = new int[clos];

        int [][] transpose = new int[clos][rows];


        for (int r=0;r<rows;r++)
        {
            for (int c=0;c<clos;c++)
            {
                transpose[c][r]= arr[r][c];
            }
        }

 return  transpose;
       }



//       transpose of matrix 2nd way  in-place transpose

    /**
     *
     *
     *
     *
     */



    public static int[][] transposematrix(int[][] mat) {
        int n=mat.length;

        for (int i=0;i<=n-2;i++)
        {
            for (int j=i+1;j<=n-1;j++)
            {
                swapmat(mat,i,j);
            }
        }

        return  mat;
}

    private static void swapmat(int[][] mat, int i, int j) {

        int temp = mat[i][j];
        mat[i][j]=mat[j][i];
        mat[j][i]=temp;
    }


//       Rotate matrix to 90deg




    public static int[][] rotatematrix90deg(int [][] matrix) {


        int row = matrix.length;
        int clos = matrix[0].length;
        int [][] ans = new int[clos][row];


        for (int r=0;r<row;r++)
        {
            for (int c=0;c<clos;c++)
            {
                ans[c][(row-1)-r] = matrix[r][c];
            }

        }
      return ans;
    }

//       (n*n) matrix only

       public static int  diagonalsum(int [][] arr) {


             int n= arr.length;
             int sum = 0;

               for (int i = 0; i < n; i++) {

                   sum+=arr[i][i];
                   sum+=arr[i][n-i-1];
               }
           // If n is odd, center element was counted twice — subtract it once
           if (n % 2 != 0) {
               sum -= arr[n / 2][n / 2];
           }




           return sum;

       }





    public static void main(String[] args) {
        int matrix[][] = new int[][]{


                { 1 ,2 ,3},
                {4 ,5 ,6},
                { 7, 8 ,9}
        };

//
//        int sum =diagonalsum(matrix);
//        System.out.println(sum);

//        int[][] ans = rotatematrix90deg(matrix);
int[][] ans = transposematrix(matrix);
        for (int[] r:ans)
        {
            for (int c:r)
            {
                System.out.print(c+" ");
            }
            System.out.println();
        }

//       int [][] arr =  printmatrix(matrix);
//
//        for (int r=0;r< arr.length;r++)
//        {
//            for (int c=0;c<arr[0].length;c++)
//            {
//                System.out.print(arr[r][c]);
//            }
//            System.out.println();
//        }
//
    }


}
