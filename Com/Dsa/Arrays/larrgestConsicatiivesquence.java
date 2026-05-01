package Com.sangram.DSA.Com.Dsa.Arrays;


import java.util.Arrays;
import java.util.HashSet;

/*
*
Given an unsorted array of integers, find the length of the longest sequence of
*  consecutive numbers (like 1,2,3,4). The numbers in the array can be in any order
*  and you don't need to use them in their original positions. You just need to find
* how long the longest chain of back-to-back integers is.
*
* Input:  [100, 4, 200, 1, 3, 2]
Output: 4
*
* Why: The longest consecutive sequence is 1, 2, 3, 4. Length = 4. 100 and 200 are isolated — no neighbors.
*
* 🔴 Brute Force
① Core idea:
For every number in the array, keep checking if the next consecutive number exists — count how far the chain goes.
* Dry-run on [100, 4, 200, 1, 3, 2]:
Start from 100 → look for 101 → not found → length 1
Start from 4   → look for 5   → not found → length 1
Start from 200 → look for 201 → not found → length 1
Start from 1   → look for 2 ✅ → look for 3 ✅ → look for 4 ✅ → look for 5 ❌ → length 4
Start from 3   → look for 4 ✅ → look for 5 ❌ → length 2
Start from 2   → look for 3 ✅ → look for 4 ✅ → look for 5 ❌ → length 3

Best = 4 ✅
*
* ③ Pseudocode:
1. For each number n in the array:
   a. Set currentLength = 1
   b. Keep looking for n+1, n+2... in the array
   c. Each time found, increment currentLength
   d. Update maxLength if currentLength is bigger
2. Return maxLength
*
* Time: O(n³) — For each of n numbers you walk the chain (up to n steps), and each step searches the whole array (n). Three nested levels of work.
Space: O(1) — You only store a few integer variables, no extra data structure.
* */
public class larrgestConsicatiivesquence {

    public static int LargestConsecutiveSequence(int[] nums) {

        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int curr_number = nums[i];
            int curr_len = 1;
            while (linear_search(nums, curr_number + 1) == true) {
                curr_number += 1;
                curr_len += 1;

            }
            max = Math.max(max, curr_len);

        }


        return max;

    }

    private static boolean linear_search(int[] nums, int i) {

        for (int n : nums) {
            if (n == i) {
                return true;
            }
        }

        return false;
    }





/*
*Better — Sort First
① Core idea:
Sort the array first, then a single pass can find consecutive sequences because equal/consecutive numbers will sit right next to each other.
* Once sorted, consecutive numbers are neighbors. You just walk and count — reset the count when the gap is more than 1, skip duplicates.
* Dry-run on [100, 4, 200, 1, 3, 2]:
After sort: [1, 2, 3, 4, 100, 200]

Walk:
1   → start new chain → length = 1
2   → 2 == 1+1 ✅ → length = 2
3   → 3 == 2+1 ✅ → length = 3
4   → 4 == 3+1 ✅ → length = 4
100 → 100 != 4+1 ❌ → reset → length = 1
200 → 200 != 100+1 ❌ → reset → length = 1

maxLength = 4 ✅
*
* ③ Pseudocode:
1. Sort the array
2. Set currentLength = 1, maxLength = 0
3. Walk from index 1 to end:
   a. If current == previous + 1 → increment currentLength
   b. If current == previous     → skip (duplicate)
   c. If current > previous + 1  → reset currentLength to 1
   d. Update maxLength
4. Return maxLength
*
*Time: O(n log n) — Sorting dominates; the single pass after is just O(n).
Space: O(1) — No extra storage beyond a few counters (sort is done in-place).
* */



   public static int  LargestConsicutivebysorting(int[] nums)
    {
        if(nums.length == 0)
        {return 0;}
        Arrays.sort(nums);
        int max =1;
        int curr_length=1;



        for(int i=1;i< nums.length;i++)
        {    // Skip duplicate numbers — they don't extend the chain
            if(nums[i] == nums[i-1])
            {
                continue;
            } else if (nums[i] == nums[i-1]+1) {

                curr_length++;
            }
            else {
                // Gap found — reset the chain
                curr_length=1;


            }


            max  = Math.max(max,curr_length);

        }
        return  max;


    }


/**
 * 🟢 Optimal — HashSet
 ① Core idea:
 Put everything in a HashSet for O(1) lookup, then only start counting a chain from numbers that have NO left neighbor — avoiding redundant work.
 *
 * The problem with brute force was: you start counting from EVERY number. So 1,2,3,4 gets counted starting from 1, then again from 2, then again from 3.
 *The key insight:
 *
 * Only start a chain from a number that has no left neighbor.
 *
 * If n-1 exists in the set, then n is in the middle of someone else's chain. Don't start from here — you'd be double-counting.
 * If n-1 does NOT exist, then n is a genuine sequence start. Count from here.
 *
 * HashSet = {100, 4, 200, 1, 3, 2}
 *
 * Check each number:
 *
 * 100 → is 99 in set? NO → start chain
 *       101 in set? NO → length = 1
 *
 * 4   → is 3 in set? YES → SKIP (not a start)
 *
 * 200 → is 199 in set? NO → start chain
 *       201 in set? NO → length = 1
 *
 * 1   → is 0 in set? NO → start chain
 *       2 in set? YES → length = 2
 *       3 in set? YES → length = 3
 *       4 in set? YES → length = 4
 *       5 in set? NO  → stop → length = 4
 *
 * 3   → is 2 in set? YES → SKIP
 *
 * 2   → is 1 in set? YES → SKIP
 *
 * maxLength = 4 ✅
 *
 *
 *
 *
 * Why is this O(n)?
 * Each number is visited at most twice — once when you check if it's a start, and once when it gets counted as part of someone else's chain. Total work across all chains = n.
 * ③ Pseudocode:
 *
 * 1. Add all numbers to a HashSet
 * 2. For each number n in the array:
 *    a. If (n-1) is NOT in the set:
 *       → n is a chain start
 *       → count upward: n+1, n+2... until not found
 *       → update maxLength
 *    b. If (n-1) IS in the set:
 *       → skip, not a chain start
 * 3. Return maxLength
 *
 *
 * ⑤ Complexity:
 *
 * Time: O(n) — Each number is touched at most twice total across all chain walks, because you only walk from genuine starts.
 * Space: O(n) — You store all n numbers in the HashSet.
 */




public static int LongestconsecutiveOptimal (int[] nums) {
    // Add every number to the set for O(1) lookup

    HashSet<Integer> set = new HashSet<>();
    for (int n:nums)
    {
        set.add(n);

    }

    int maxlength = 0;
    for (int n:set)
    {
        // Only start counting if n is the beginning of a sequence
        // A number is a start only if its left neighbor doesn't exist

        if (!set.contains(n-1))
        {
            int current_num = n;
            int current_len = 1;
            // Walk the chain upward as long as next number exists
            while (set.contains(current_num+1))
            {
                current_num++;
                current_len++;

            }

           maxlength = Math.max(maxlength,current_len);
        }
    }

    // TODO: Implement logic

return maxlength;
}

    public static void main(String[] args) {
        int[] arr = new int[]{100, 4, 200, 1, 2, 3};
        System.out.println(LargestConsecutiveSequence(arr)+" ");
        System.out.println(LargestConsicutivebysorting(arr)+" ");
        System.out.println(LongestconsecutiveOptimal(arr));
    }

}