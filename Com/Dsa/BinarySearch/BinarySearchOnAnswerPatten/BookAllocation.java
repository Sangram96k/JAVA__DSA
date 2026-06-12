package Com.sangram.DSA.Com.Dsa.BinarySearch.BinarySearchOnAnswerPatten;
/*
 * ================================================================
 * 🧠 PROBLEM: Book Allocation Problem
 * ================================================================
 *
 * Author : Sangram Chavanpatil
 * Date   : 2026-05-19
 *
 * ------------------------------------------------
 * 📌 Problem Statement & Example Analysis:
 * Given an array 'nums' of n integers, where nums[i] represents the number
 * of pages in the i-th book, and an integer 'm' representing the number
 * of students. Allocate all books to the students such that:
 * 1. Each student gets at least one book.
 * 2. Each book is allocated to exactly one student.
 * 3. The allocation must be contiguous (sequential).
 *
 * Goal: Allocate books to minimize the maximum pages assigned to any student.
 * If allocation is fundamentally impossible, return -1.
 *
 * Example 1: nums = [12, 34, 67, 90], m = 2
 * - Possible valid allocations (contiguous cuts):
 *   👉 [12] | [34, 67, 90]   -> Max pages = max(12, 191)  = 191
 *   👉 [12, 34] | [67, 90]   -> Max pages = max(46, 157)  = 157
 *   👉 [12, 34, 67] | [90]   -> Max pages = max(113, 90)  = 113
 * - Optimal strategy: Minimize this maximum barrier. Output: 113
 *
 * ------------------------------------------------
 * 💡 Approach: (Binary Search on Answer Space)
 * 1. Identify Edge Case: If students (m) > books (n), return -1.
 * 2. Define the search space bound limits for the answer (page capacity):
 *    - low  = max(nums) -> The largest single book (since a book cannot be split).
 *    - high = sum(nums) -> If 1 student had to read every single book.
 * 3. Use Binary Search to guess a target maximum page barrier ('mid'):
 *    - Greedily accumulate pages for the current student.
 *    - If adding the next book exceeds 'mid', assign it to the next student.
 * 4. If we can successfully distribute all books to <= m students, 'mid' is
 *    a viable maximum barrier. Save it and try to find a tighter, lower
 *    threshold in the left half (high = mid - 1).
 * 5. If we need > m students, 'mid' is too small/restrictive. Search the
 *    right half to increase the capacity (low = mid + 1).
 *
 * ------------------------------------------------
 * ⏱ Time Complexity  : O(N log(sum(nums) - max(nums)))
 * 🗂 Space Complexity : O(1)
 *
 * ------------------------------------------------
 * 📝 Notes: Why do we return 'high' (or 'ans')?
 * The search splits the barrier range into a [False, False, ..., True, True] template.
 * When the loop terminates (low > high), 'high' drops to the point just below 'low',
 * matching the exact boundary value of the minimum valid page configuration.
 * ================================================================
 */
public class BookAllocation {
    public static void main(String[] args) {
        int[] arr = new int[]{12, 34, 67, 90};

        System.out.println(  bookallacations(arr,2));
    }

    private static int  bookallacations(int[] arr, int m) {
        int n= arr.length;


        if(m>n)
        {
            return -1;
        }
        int low=0;int high=0;
        for(int pages:arr)
        {
            low=Math.max(low,pages);
            high+=pages;
        }
        int ans=-1;
        while(low<=high)
        {
            int mid = low+(high-low)/2;

            if (isPossible(arr,mid,m))
            {
                ans=mid;
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }
        return low;
    }

    private static boolean isPossible(int[] arr, int maxPagesAllowed, int m) {

        int stud_count=1;
        int currentpagesassigned = 0;

        for(int i=0;i<arr.length;i++)
        {
            // If the single book exceeds the ceiling barrier, configuration fails
            if (arr[i] > maxPagesAllowed) {
                return false;
            }
            if(currentpagesassigned+arr[i]<=maxPagesAllowed)
            {
                currentpagesassigned+=arr[i];
            }
            else {
                stud_count++;
                currentpagesassigned=arr[i];
            }
        }

        return stud_count<=m;
    }
}
