package Com.sangram.DSA.Com.Dsa.BinarySearch;
/*
 * ================================================================
 * 🧠 PROBLEM: Search in Rotated Sorted Array II
 * ================================================================
 *
 * Author : Sangram Chavanpatil
 * Date   : 2026-05-10
 *
 * ------------------------------------------------
 * 📌 Problem Statement:
 * There is an integer array nums sorted in non-decreasing order
 * (not necessarily with distinct values).
 *
 * Before being passed to your function, nums is rotated at an unknown
 * pivot index k (0 <= k < nums.length) such that the resulting array is
 * [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]].
 * For example, [0,1,2,4,4,4,5,6,6,7] rotated at index 5 becomes
 * [4,5,6,6,7,0,1,2,4,4].
 *
 * Given the array nums after the rotation and an integer target,
 * return true if target is in nums, or false if it is not in nums.
 * You must decrease the overall operation steps as much as possible.
 *
 * Example 1:
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 *
 * Example 2:
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 *
 * ------------------------------------------------
 * 💡 Approach:
 * BRUTE-FORCE: Linear search — scan every element and check if it equals target.
 *
 * OPTIMAL: Modified Binary Search
 *
 * Step 1: Set low = 0, high = nums.length - 1, mid = low + (high - low) / 2
 *
 * Step 2: If nums[mid] == target, return true immediately.
 *
 * Step 3: Handle the DUPLICATE edge case first.
 *         If nums[low] == nums[mid], we cannot determine which half is sorted.
 *         Example: [1,1,1,0,1] — left looks sorted but isn't reliably.
 *         Fix: Just do low++ to shrink the window and continue.
 *
 * Step 4: LEFT HALF SORTED — if nums[low] < nums[mid]
 *         Check if target lies within [nums[low], nums[mid]).
 *         If yes → search left half (high = mid - 1).
 *         If no  → search right half (low = mid + 1).
 *
 * Step 5: RIGHT HALF SORTED — if nums[low] > nums[mid]
 *         Check if target lies within (nums[mid], nums[high]].
 *         If yes → search right half (low = mid + 1).
 *         If no  → search left half (high = mid - 1).
 *
 * Step 6: If loop ends without finding target, return false.
 *
 * Key Difference from Problem 33 (no duplicates):
 * Problem 33 never needs step 3 because nums[low] == nums[mid]
 * can only happen when low == mid (single element), which is safe.
 * Here duplicates can make nums[low] == nums[mid] even across a wide
 * range, so we must handle it explicitly.
 *
 * ------------------------------------------------
 * BRUTE-FORCE:
 * ⏱ Time Complexity  : O(N)
 * 🗂 Space Complexity : O(1)
 *
 * OPTIMAL:
 * ⏱ Time Complexity  : O(log N) average — O(N) worst case (all duplicates)
 * 🗂 Space Complexity : O(1)
 *
 * ------------------------------------------------
 * 📝 Notes:
 * The worst case O(N) is unavoidable for this problem when duplicates
 * exist. Example: [1,1,1,1,1,1,0,1] — we cannot skip any element
 * with certainty so we degrade to linear in the worst case.
 * ================================================================
 */
public class searchInRotatedSortedArray2 {

    public static void main(String[] args) {
       boolean ans =searchinrotatedsortedarray2(new int[]{2,5,6,0,0,1,2},2);
    }

    private static boolean searchinrotatedsortedarray2(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // ✅ Found the target
            if (nums[mid] == target) return true;

            // ✅ Step 3: Duplicate edge case — can't determine sorted half
            if (nums[low] == nums[mid]) {
                low++;
                continue;
            }

            // ✅ Step 4: Left half is sorted
            if (nums[low] < nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;   // target lies in left half
                } else {
                    low = mid + 1;    // target lies in right half
                }
            }
            // ✅ Step 5: Right half is sorted
            else {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;    // target lies in right half
                } else {
                    high = mid - 1;   // target lies in left half
                }
            }
        }

        return false; // target not found

    }
}
