package Com.sangram.DSA.Com.Dsa.BinarySearch;


/*
 * ================================================================
 * 🧠 PROBLEM:  Search in Rotated Sorted Array
 * ================================================================
 *
 * Author : Sangram Chavanpatil
 * Date   : 2026-05-10
 *
 * ------------------------------------------------
 * 📌 Problem Statement:
 * There is an integer array nums sorted in ascending order (with distinct values).
 *
 * Prior to being passed to your function, nums is possibly left rotated at an unknown index k (1 <= k < nums.length)
 * such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 * For example, [0,1,2,4,5,6,7] might be left rotated by 3 indices and become [4,5,6,7,0,1,2].
 *
 * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 *
 * You must write an algorithm with O(log n) runtime complexity.

 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4


 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1

 * Example 3:
 * Input: nums = [1], target = 0
 * Output: -1

 *
 * ------------------------------------------------
 * 💡 Approach:
 * BRUTE-FORCE: Linear search
 *
 * OPTIMAL approach
 * Binary Search
 * step 1: use pointers low and the start 0 index and the high at the end index and mid at the middle index(low+high)/2
 *
 * step 2: check if the left portion is sorted or not compare the arr[low]<=arr[high];
 * if it is sorted, then check if the target is present in the left portion
 * if the target is present in the left portion, then we will ignore the right section and only move on with the left section and find the index of the target
 *
 *
 * CASE 2: if the left is not sorted, move to the right and check if the right portion has the target if yes then ignore the left and only move with the right section and
 * find the index of the target
 *
 *
 *
 * ------------------------------------------------
 * Bruteforce:
 * ⏱ Time Complexity: O(N)
 * 🗂 Space Complexity :O(1)
 *
 * OPTIMAL:
 * ⏱ Time Complexity: O(nlogn)
 * 🗂 Space Complexity :O(1)
 *
 * ------------------------------------------------
 * 📝 Notes:
 * 
 * ================================================================
 */

public class searchInRotatedSortedArray {


    public static void main(String[] args) {
        int[] arr = new int[]{4,5,6,7,0,1,2};
        int target = 4;

        int ans = searchinrotatedsortedarray(arr,target);
        System.out.println(ans);
    }

    private static int  searchinrotatedsortedarray(int[] arr, int target) {

        int low = 0;
        int high = arr.length-1;
        while (low<=high)
        {

            int mid = low+(high-low)/2;

            if (arr[mid]==target) return mid;

            if (arr[low]<=arr[mid])
            {
                if(target>=arr[low]&&target<=arr[mid])
                {
                    high=mid-1;
                }
                else {
                    low=mid+1;
                }
            }
            else {
                if(target>=arr[mid]&&target<=arr[high])
                {
                    low = mid+1;
                }
                else{
                    high=mid-1;
                }
            }
        }

        return -1;



    }

}
