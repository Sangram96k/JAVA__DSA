package Com.sangram.DSA.Com.Dsa.BinarySearch;
/*
 * ================================================================
 * 🧠 PROBLEM: Find Minimum in Rotated Sorted Array
 * ================================================================
 *
 * Author : Sangram Chavanpatil
 * Date   : 2026-05-10
 *
 * ------------------------------------------------
 * 📌 Problem Statement:Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.

You must write an algorithm that runs in O(log n) time.



Example 1:

Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.
Example 2:

Input: nums = [4,5,6,7,0,1,2]
Output: 0
Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
Example 3:

Input: nums = [11,13,15,17]
Output: 11
Explanation: The original array was [11,13,15,17] and it was rotated 4 times.
 * 
 *
 * ------------------------------------------------
 * 💡 Approach:
 *
 * First check if the left section of the array is sorted if sorted then pick the low as the min and then move to the
 * rigth ignore left as we picked min form left now pick min from the rigth and compare and save the mininmun from those
 *
 *
 * 
 *
 * ------------------------------------------------
 * ⏱ Time Complexity  : 
 * 🗂 Space Complexity : 
 *
 * ------------------------------------------------
 * 📝 Notes:
 * 
 * ================================================================
 */

public class minInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{4,5,6,7,0,1,2};
       int ans= mininroatedsortedarray(arr);
        System.out.println(ans);
    }

    private static int mininroatedsortedarray(int[] arr) {
        int min = Integer.MAX_VALUE;
        int low = 0;
        int high=arr.length-1;

        while (low<=high)
        {
            int mid = low+(high-low)/2;
//            If left is sorted
            if (arr[low]<=arr[mid])
            {
                min = Math.min(min,arr[low]);
//                move to right for the min
                low=mid+1;

            }

//            right is sorted
            else{
                min = Math.min(min,arr[mid]);
                high=mid-1;

            }
        }
        
        
        return min;
    }
}
