package Com.sangram.DSA.Com.Dsa.BinarySearch;
/*
 * ================================================================
 * 🧠 PROBLEM: Kth Missing Positive Number (LeetCode 1539)
 * ================================================================
 *
 * Author : Sangram Chavanpatil
 * Date   : 2026-05-18
 *
 * ------------------------------------------------
 * 📌 Problem Statement:
 * Given a sorted array 'arr' of positive integers and an integer 'k',
 * find the kth missing positive integer.
 *
 * ------------------------------------------------
 * 💡 Approach:
 * 1. Use Binary Search to look at the array indices rather than
 *    just the values.
 * 2. At any given index 'mid', calculate how many numbers are
 *    missing before it using the formula: missing = arr[mid] - (mid + 1).
 * 3. If 'missing < k', it means the kth missing number lies to the
 *    right side, so shift the 'low' pointer to 'mid + 1'.
 * 4. If 'missing >= k', the kth missing number lies to the left
 *    side (or could be related to 'mid'), so shift 'high' to 'mid - 1'.
 * 5. Once 'low' and 'high' cross each other, the loop terminates.
 *    The final answer naturally simplifies to: low + k.
 *-------------------------------------------------
 * Example 1:

Input: arr = [2,3,4,7,11], k = 5
Output: 9
Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
Example 2:

Input: arr = [1,2,3,4], k = 2
Output: 6
Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.
 * ------------------------------------------------
 * ⏱ Time Complexity  : O(log N)
 * 🗂 Space Complexity : O(1)
 *
 * ------------------------------------------------
 * 📝 Notes: Why do we return (low + k)?
 *
 * When the loop terminates, 'high' and 'low' cross paths (low = high + 1).
 * 'high' ends up at the largest index where missing elements are < k.
 *
 * Derivation from 'high':
 *   - Missing elements up to high = arr[high] - (high + 1)
 *   - Remaining missing elements needed = k - [arr[high] - (high + 1)]
 *   - Final Answer = arr[high] + Remaining Needed
 *                  = arr[high] + k - arr[high] + (high + 1)
 *                  = high + 1 + k
 *
 * Since the loop ended, we substitute (high + 1) with 'low':
 *   - Final Answer = low + k
 *
 * Intuition: 'low' is the count of valid array numbers smaller than
 * our target. To find the kth missing number, we take 'k' and simply
 * skip over those 'low' existing numbers.
 * ================================================================
 */
public class nthpositivenumber {


    
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,4,7,11};
        System.out.println( nthmissingnumer(arr,5));

    }

    private static int nthmissingnumer(int[] arr, int k) {
        int low=0,high= arr.length-1;

        while (low<=high)
        {
            int mid = low+(high-low)/2;

            int missing =  arr[mid]-(mid+1);

            if (missing<k)
            {
                low=mid+1;
            }
            else{
                high=mid-1;
            }

        }
        return low+k;
    }
}
