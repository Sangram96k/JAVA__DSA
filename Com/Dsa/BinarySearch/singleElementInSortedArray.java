package Com.sangram.DSA.Com.Dsa.BinarySearch;


/*
 * ================================================================
 * 🧠 PROBLEM: Single element in sorted array
 * ================================================================
 *
 * Author : Sangram Chavanpatil
 * Date   : 2026-05-11
 *
 * ------------------------------------------------
 * 📌 Problem Statement:
 *You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.



Example 1:

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: nums = [3,3,7,7,10,11,11]
Output: 10
 *
 * ------------------------------------------------
 * 💡 Approach:
 * function singleNonDuplicate(nums):

    low = 0, high = nums.length - 1

    while low <= high:

        mid = low + (high - low) / 2

        // found the answer conditions
        if nums[mid] != nums[mid+1] AND nums[mid] != nums[mid-1]:
            return nums[mid]

        // mid is EVEN
        if mid is EVEN:
            if nums[mid] == nums[mid+1]:
                pair intact → go RIGHT → low = mid+2
            else:
                pattern broken → go LEFT → high = mid-1

        // mid is ODD
        if mid is ODD:
            if nums[mid] == nums[mid-1]:
                pair intact → go RIGHT → low = mid+1
            else:
                pattern broken → go LEFT → high = mid-1

    return nums[low]
 *
 * ------------------------------------------------
 * ⏱ Time Complexity :O(logn)
 * 🗂 Space Complexity :O(1);
 *
 * ------------------------------------------------
 * 📝 Notes:
 *
 *
 * take care about the boundries like 0 < mid < n-1 other wise we will get and index out of bound error
 *
 * ================================================================
 */

public class singleElementInSortedArray {

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2,3,3,4,4,8,8};
        int[] arr1 = new int[]{1,2,3,4,1,2,4};
        int ans = singleelementinsortedarray(arr);
//        System.out.println(ans);

        int an = singleelementinsortedarray2(arr1);
        System.out.println(an);
    }



    private static int singleelementinsortedarray(int[] arr) {
        int low=0;int high=arr.length-1;
        while (low<=high)
        {
            int mid = low+(high-low)/2;

            // boundary checks before comparing neighbors
            boolean leftMatch  = (mid > 0) && arr[mid] == arr[mid - 1];
            boolean rightMatch = (mid < arr.length - 1) && arr[mid] == arr[mid + 1];

            if(!leftMatch&&!rightMatch)
            {
                return arr[mid];
            }
            if (mid%2==0)  // mid is even
            {
                if(rightMatch)
                {
//                    move to right as the pair is intact
                    low=mid+2;

                }
                else {
//                    move left as the pair is broken
                    high = mid-1;
                }
            }

            else {            // mid is ODD

                if (leftMatch)
                {
                    low= mid+1;  // pair intact → go right
                }
                else {
                    high = mid-1;   // pattern broken → go left
                }
            }
        }



        return arr[low];
    }



    public  static  int singleelementinsortedarray2(int[] arr)
    {

        int n = arr.length;
        if(arr.length==1) return 0;
        if(arr[0]>arr[1]) return 0;   // because on the left of the arr[0] is -infinity so i only need to check if the right is greateter the just return no need for binary searfch
        if(arr[n-1]>arr[n-2]) return n-1; // here also same just check the left element of the last it if it si small the  the peak is last element

        // if none of the case satisfies the go for binary search

        int low =1;
        int high =n-2;
        while (low<=high)
        {
            int mid = low+(high-low)/2;

            if(arr[mid-1]<arr[mid]&&arr[mid]>arr[mid+1])
            {
                return mid;
            }
            else if(arr[mid]>arr[mid-1])
            {
                low=mid+1;
            }
            else {
                high = mid-1;
            }


        }



      return -1;
    }

}
