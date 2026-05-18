package Com.sangram.DSA.Com.Dsa.BinarySearch;
/*
 * ================================================================
 * 🧠 PROBLEM: Safe Buildings After Flood
 * ================================================================
 *
 * Author : Sangram Chavanpatil
 * Date   : 2026-05-11
 *
 * ------------------------------------------------
 * 📌 Problem Statement:
 * A city has n buildings along a street with heights stored in an array.
 * The array was originally sorted in strictly ascending order but has
 * been rotated at some unknown pivot index.
 *
 * After heavy rainfall, the water level rises to exactly waterLevel units.
 * A building is considered "safe" only if its height is STRICTLY GREATER
 * than the waterLevel.
 *
 * Given the rotated heights array and an integer waterLevel,
 * return the COUNT of safe buildings.
 *
 * Your algorithm must run in O(log n) time.
 *
 * Example 1:
 * Input : heights = [6, 8, 10, 1, 2, 4, 5], waterLevel = 5
 * Output: 3
 * Explanation: Buildings taller than 5 are [6, 8, 10] → 3 buildings
 *
 * Example 2:
 * Input : heights = [4, 5, 6, 7, 0, 1, 2], waterLevel = 3
 * Output: 4
 * Explanation: Buildings taller than 3 are [4, 5, 6, 7] → 4 buildings
 *
 * Example 3:
 * Input : heights = [2], waterLevel = 1
 * Output: 1
 *
 * Example 4:
 * Input : heights = [3, 1, 2], waterLevel = 5
 * Output: 0
 *
 * Constraints:
 * - 1 <= n <= 10^4
 * - -10^4 <= heights[i] <= 10^4
 * - All values in heights are DISTINCT
 * - waterLevel can be any integer
 *
 * ------------------------------------------------
 * 💡 Approach:
 *  First find the pivot point it gives us two sorted halves
 *
 * then in halfs if do binary search for the safe cities(that is elements that are greter than the water level element )
 *
 *
 *
 *
 *
 *
 *
 *
 *
 * ------------------------------------------------
 * BRUTE-FORCE:
 * ⏱ Time Complexity  : O( )
 * 🗂 Space Complexity : O( )
 *
 * OPTIMAL:
 * ⏱ Time Complexity  : O( )
 * 🗂 Space Complexity : O( )
 *
 * ------------------------------------------------
 * 📝 Notes:
 *
 * ================================================================
 */

public class safeCity {

    public static void main(String[] args) {
//       int ans= findpivot(new int[]{4,5,6,1,2,3});
       int ans= safecities(new int[]{4,5,6,1,2,3},4);
        System.out.println(ans);
    }

public static int counter(int[] arr,int low,int h,int WL)
{
    int high = h;
    int count = h+1;

    while (low<=high)
    {
        int mid = low+(high-low)/2;
        if(arr[mid]>WL)
        {
            count=mid;
            high=mid-1;

        }
        else{
            low=mid+1;
        }
    }
    return h-count+1;
}
    public static int safecities(int[] arr,int waterlevel)
    {
 int count=0;
        int pivot = findpivot(arr);

        if(pivot == 0)
        {
            count = counter(arr,0, arr.length-1,waterlevel );
        }

int n = arr.length;
        int left = counter(arr,0,pivot-1,waterlevel);
        int rigth = counter(arr,pivot,n-1,waterlevel);

        return left+rigth;
    }
    public static  int findpivot(int [] arr)
    {
        int low = 0;
        int high= arr.length-1;
        int min = 0;


        while (low<=high) {

            int mid = low+(high-low)/2;

//        if the left section is sorted
            if(arr[low]<=arr[mid])
            {
                if(arr[low]<arr[min])
                {
                    min = low;
                }
//
                    low=mid+1;



            }
            else{
                if(arr[mid]<arr[min])
                {
                    min = mid;

                }

                    high = mid-1;

            }
        }

return min;
    }
}
