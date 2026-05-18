package Com.sangram.DSA.Com.Dsa.BinarySearch.BinarySearchOnAnswerPatten;

import java.util.Arrays;

/*
 * ================================================================
 * 🧠 PROBLEM: Aggressive Cows
 * ================================================================
 *
 * Author : Sangram Chavanpatil
 * Date   : 2026-05-18
 *
 * ------------------------------------------------
 * 📌 Problem Statement & Example Analysis:
 * Given stall coordinates 'nums' and 'k' aggressive cows, place them
 * such that the minimum distance between any two cows is maximized.
 *
 * Example 1: nums = [0, 3, 4, 7, 10, 9], k = 4
 * - Sorted Stalls: [0, 3, 4, 7, 9, 10]
 * - If we place cows at: [0, 3, 4, 7] -> Distances = [3, 1, 3] -> Min = 1 (Too close!)
 * - Best placement:     [0, 3, 7, 10] -> Distances = [3, 4, 3] -> Min = 3
 * No other placement of 4 cows can achieve a larger minimum distance. Output: 3
 *
 * ------------------------------------------------
 * 💡 Approach: (Binary Search on Answer Space)
 * 1. Sort the stall array to establish a linear, ordered spatial line.
 * 2. Define the search space for the answer (distance):
 *    - low = 1 (minimum possible distance separation)
 *    - high = max stall coordinate (maximum possible distance range)
 * 3. Use Binary Search to guess a target minimum distance ('mid'):
 *    - Greedily place the first cow at nums[0].
 *    - Place subsequent cows only at stalls where distance >= mid.
 * 4. If we successfully place >= k cows, 'mid' is achievable. Save it
 *    and try a larger buffer in the right half (low = mid + 1).
 * 5. If we place < k cows, 'mid' is too large. Search the left half (high = mid - 1).
 *
 * ------------------------------------------------
 * ⏱ Time Complexity  : O(N log N + N log(max_distance))
 * 🗂 Space Complexity : O(1)
 *
 * ------------------------------------------------
 * 📝 Notes: Why do we return 'high'?
 * The binary search splits the distance range into a [True, True, ..., False, False] template.
 * When the loop terminates (low > high), 'high' retreats to point to the last distance
 * configuration that returned 'True' (the maximum valid minimum distance).
 * ================================================================
 */
public class Agressivecow {

    public static void main(String[] args) {
        int[] arr=new int[]{0, 3, 4, 7, 10, 9};
        System.out.println(aggressive(arr,4));


    }

    private static int aggressive(int[] arr, int k) {


        Arrays.sort(arr);
        int low=1;
        int n= arr.length;
        int high=arr[n-1]-arr[0];

        
        while (low<=high)
        {
            int mid = low+(high-low)/2;
            
            boolean ans = ispossible(arr,mid,k);
            if(ans)
            {
                low=mid+1;
            }
            else {
                high=mid-1;
            }
            
        }

        return high;
    }

    private static boolean ispossible(int[] arr, int dist, int k) {


        int cowcnt=1; int last=arr[0];

        for(int i=1;i< arr.length;i++)
        {
            if (arr[i]-last>=dist)
            {
                cowcnt++;
                last=arr[i];
            }

        }

        if(cowcnt>=k)
        {
            return true;
        }
        return false;

    }
}
