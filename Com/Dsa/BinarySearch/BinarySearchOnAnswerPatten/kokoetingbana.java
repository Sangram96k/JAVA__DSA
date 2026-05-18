package Com.sangram.DSA.Com.Dsa.BinarySearch.BinarySearchOnAnswerPatten;
/*
 * ================================================================
 * 🧠 PROBLEM: Koko Eating Bananas
 * ================================================================
 *
 * Author : Sangram Chavanpatil
 * Date   : 2026-05-13
 *
 * ------------------------------------------------
 * 📌 Problem Statement:
 * Koko loves to eat bananas. There are n piles of bananas, where
 * piles[i] is the number of bananas in the ith pile. The guards
 * return in h hours.
 *
 * Koko can decide her eating speed k (bananas-per-hour). Each hour,
 * she chooses a pile and eats k bananas. If the pile has fewer than
 * k, she eats the whole pile and stops for that hour.
 *
 * Return the minimum integer k such that she can eat all bananas
 * within h hours.
 *
 * Example 1:
 * Input : piles = [3, 6, 7, 11], h = 8
 * Output: 4
 *
 * Example 2:
 * Input : piles = [30, 11, 23, 4, 20], h = 5
 * Output: 30
 *
 * Constraints:
 * - 1 <= piles.length <= 10^4
 * - piles.length <= h <= 10^9
 * - 1 <= piles[i] <= 10^9
 *
 * ------------------------------------------------
 * 💡 Approach:
 * 1. The range for the possible speed 'k' is between 1 and the
 *    maximum value in the piles array (max(piles)).
 * 2. We use Binary Search on this range to find the minimum 'k'.
 * 3. For a chosen 'mid' speed, calculate the total hours required:
 *    Hours = sum(ceil(pile / mid)).
 * 4. If total hours <= h, 'mid' is a potential answer; try slower
 *    speeds (high = mid - 1).
 * 5. Otherwise, the speed is too slow; try faster speeds (low = mid + 1).
 *
 * ------------------------------------------------
 * BRUTE-FORCE:
 * ⏱ Time Complexity  : O(max(piles) * n)
 * 🗂 Space Complexity : O(1)
 *
 * OPTIMAL (Binary Search):
 * ⏱ Time Complexity  : O(n * log(max(piles)))
 * 🗂 Space Complexity : O(1)
 *
 * ------------------------------------------------
 * 📝 Notes:
 * - Use 'long' for total hours to prevent overflow during summation.
 * - Use integer math (p + mid - 1) / mid for ceiling to avoid
 *   floating-point precision errors.
 * ================================================================
 */


public class kokoetingbana {
    public static void main(String[] args) {
        int[] arr = new int[]{3,6,7,11};

        int ans = kokoetingbanana(arr,8);
        System.out.println(ans);
    }
    public static int kokoetingbanana (int [] arr,int h) {
        int low = 1;
//    high is the maximum highest element in the array for now assume it 0
        int high=0;

        for(int i:arr)
        {
            high = Math.max(i,high);
        }



        int ans =high;
        while (low<=high)
        {
            int mid = low+(high-low)/2;

           long totalhrs = calculatehrs(arr,mid);
           if(totalhrs<=h)
           {
               ans = mid;
               high=mid-1;
           }
           else {
               low=mid+1;
           }
        }


        return ans;

    }

    private static long calculatehrs(int[] arr, int mid) {

        long totalhrs = 0;


        for (int i:arr)
        {

//             this can casue overflow when the number is larger
//            totalhrs+=Math.ceil(i/mid);

            // Integer ceiling division: ceil(a/b) = (a + b - 1) / b
            totalhrs += (long)(i+mid-1)/mid;
        }
        return totalhrs;
    }


}
