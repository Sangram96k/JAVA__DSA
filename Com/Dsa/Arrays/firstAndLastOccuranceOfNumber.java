package Com.sangram.DSA.Com.Dsa.Arrays;




/*
 * ================================================================
 * 🧠 PROBLEM: . Find First and Last Position of Element in Sorted Array
 * ================================================================
 *
 * Author : Sangram Chavanpatil
 * Date   : 2026-05-08
 *
 * ------------------------------------------------
 * 📌 Problem Statement:
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 xample 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]

 *
 * ------------------------------------------------
 * 💡 Approach:
 * 
 *
 * ------------------------------------------------
 * Brute force
 * ⏱ Time Complexity  : O(n)
 * 🗂 Space Complexity : O(1)
 * Optimal
 *⏱ Time Complexity  : O(logn)
 * 🗂 Space Complexity :
 * ------------------------------------------------
 * 📝 Notes:
 * 
 * ================================================================
 */

public class firstAndLastOccuranceOfNumber {

    public static void main(String[] args) {
      int[] ans=  firstandlatcccranceofelement(new int[]{1,1,2,2,2,4,5},2);
        for (int i:ans)
        {
            System.out.print(i+" ");
        }


        firstandlastoccuranceOptimal(new int[] {1,2,2,3,4,4,4,5,5,6},4);
    }



//    _____________________-Optimal____________________________________________________________________________

    private static int[] firstandlastoccuranceOptimal(int[] arr, int target) {
          return new int[]{first(arr,target),last(arr,target)};
    }

    public static int first(int[] arr, int target) {

        int first=-1;
        int low = 0;
        int high= arr.length-1;

        while (low<=high)
        {
            int mid = low+(high-low)/2;

            if(arr[mid]==target)
            {
                first=mid;
                high = mid-1;
            } else if (target>arr[mid]) {

                low=mid+1;
            }
            else {
                high = mid-1;
            }

        }
        return first;
    }

    public static int last(int[] arr, int target) {
        int last=-1;
        int low = 0;
        int high= arr.length-1;

        while (low<=high)
        {
            int mid = low+(high-low)/2;

            if(arr[mid]==target)
            {
                last=mid;
                low = mid+1;

            } else if (target>arr[mid]) {

               low = mid+1;
            }
            else {
                high = mid-1;
            }

        }
        return  last;
    }
    //---------------------------Optimal sloution end-------------------------------------------------------------------



    //------------------------------Brute-Force sloution----------------------------------------------------------------


    private static int[] firstandlatcccranceofelement(int[] arr, int target) {

        int firstoccrence=-1; int lastoccurence = -1;

        for (int j = 0; j < arr.length; j++) {
            if(arr[j]== target)
            {
                if (firstoccrence==-1)
                {
                    firstoccrence = j;

                }

                else {
                    lastoccurence = j;
                }
            }
        }

        return  new int[]{firstoccrence,lastoccurence};
    }



}


