package Com.sangram.DSA.Com.Dsa.Arrays;

import java.util.HashSet;

public class setMatrixZero {

    public static void setmatrixzero (int[][] nums) {
/**
 * // Example: A 3x4 Matrix (3 rows and 4 columns)
 *         int[][] matrix = {
 *
 *                 c1, c2, c3, c4
 *  row      I    {1,  2,  3,  4},
 *  row      II    {5, 6, 7, 8},
 *  row     III    {9, 10, 11, 12}
 *         };
 *
 * first traverse the matrix and when we find the zero first convert all the elements in the row and cloumn of that matrix
 *  -1 and traverse every array and after marking rows and columns to -1 convert the -1 to 0
 *
 *
 */

        //        number of rows
        int m = nums.length;
//        number of columns
        int n=nums[0].length;

        for(int i=0;i<m;i++)
        {
            for (int j=0;j<n;j++)
            {

                if (nums[i][j]==0) {
//                    her i passed the the row which is to be marked (i) and we want to mark the whole row so here i passed the number of columns
                    MarkRow(i,nums,n);
//                    similarly here i passed the cloum to mark and the number of rows so we can mark entire column
                    MarkCol(j,nums,m);
                }
            }
        }
//        now we have to convert all the marked element to 0

        for (int i=0;i<m;i++)
        {
            for (int j=0;j<n;j++)
            {
                if(nums[i][j]==-1)
                {
                    nums[i][j]=0;
                }
            }
        }
    }

    private static void MarkCol(int j, int[][] nums, int m) {

        for (int i=0;i<m;i++)
        {
//            Mark/convert/overrite all the element in the specific column which are not 0 to -1;
            if(nums[i][j]!=0)
            {
                nums[i][j]=-1;
            }
        }
    }

    private static void MarkRow(int i, int[][] nums, int n) {
        for (int j=0;j<n;j++)
        {
            if(nums[i][j]!=0)
            {
                nums[i][j]=-1;
            }
        }
    }


/**
 *  Better solution :
 *  ① Core idea:
 * Instead of traversing the whole matrix, just record which rows and which columns need to be zeroed, then apply them in a second pass.  like exactly pinpointing which cell needs to be zeroed
 * Dry-run on Example 2:
 * Matrix:
 * 0  1  2  0
 * 3  4  5  2
 * 1  3  1  5
 *
 * Pass 1 — scan and record:
 * (0,0) = 0 → zeroRows = {0}, zeroCols = {0}
 * (0,3) = 0 → zeroRows = {0}, zeroCols = {0, 3}
 *
 * Pass 2 — apply:
 * Row 0 is in zeroRows → wipe row 0: [0,0,0,0]
 * Col 0 is in zeroCols → wipe col 0: all rows, col 0 = 0
 * Col 3 is in zeroCols → wipe col 3: all rows, col 3 = 0
 *
 * Final:
 * 0  0  0  0
 * 0  4  5  0
 * 0  3  1  0  ✅
 * ③ Pseudocode:
 * Create a set: zeroRows
 * Create a set: zeroCols
 *
 * Pass 1 — scan entire matrix:
 *     if matrix[r][c] == 0:
 *         add r to zeroRows
 *         add c to zeroCols
 *
 * Pass 2 — apply zeros:
 *     For each cell (r, c):
 *         if r is in zeroRows OR c is in zeroCols:
 *             matrix[r][c] = 0
 *
 * Return matrix
 *
 *
 *
 *
 */



public static void setmatrixzeroBetter(int[][] nums) {

    int rows = nums.length;
    int cols = nums[0].length;

    HashSet<Integer> rowset = new HashSet<>();
    HashSet<Integer> colset = new HashSet<>();

    for(int r=0;r<rows;r++)
    {
        for (int c=0;c<cols;c++)
        {
            if(nums[r][c]==0)
            {
                rowset.add(r);
                colset.add(c);
            }
        }

    }


    // Pass 2: zero out any cell whose row or col was flagged

    for (int r=0;r<rows;r++)
    {
        for (int c=0;c<cols;c++)
        {
            if(rowset.contains(r)||colset.contains(c))
            {
                nums[r][c]=0;
            }
        }
    }

}


    public static void main(String[] args) {
        int[][] matrix = {
                {1,1,1,1},
                {1,0,0,1},
                {1,1,0,1},
                {1,1,1,1,}
        };

//        setmatrixzero(matrix);
        setmatrixzeroBetter(matrix);
        for (int i=0;i<matrix.length;i++)
        {
            for (int j=0;j<matrix[0].length;j++)
            {
                System.out.print(matrix[i][j]);

            }
            System.out.println();
        }

    }
}
