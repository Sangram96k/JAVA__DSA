package Com.sangram.DSA.Com.Dsa.BinarySearch.BinarySearchOnAnswerPatten;
/*
 * ================================================================
 * 🧠 PROBLEM: Efficient Freight Distribution
 * ================================================================
 *
 * Author : Sangram Chavanpatil
 * Date   : 2026-05-13
 *
 * ------------------------------------------------
 * 📌 Problem Statement:
 * A logistics hub has n cargo containers lined up in a fixed order.
 * The weight of the ith container is weights[i]. These containers
 * must be loaded onto k ships in the EXACT order they appear.
 *
 * Each ship has a maximum weight capacity. You need to determine
 * the minimum possible capacity for these ships such that all
 * containers can be shipped using exactly k ships (or fewer).
 *
 * Example 1:
 * Input : weights = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 5
 * Output: 15
 * Explanation:
 * Ship 1: [1, 2, 3, 4, 5] (sum 15)
 * Ship 2: [6, 7]          (sum 13)
 * Ship 3: [8]             (sum 8)
 * Ship 4: [9]             (sum 9)
 * Ship 5: [10]            (sum 10)
 * The maximum load is 15. Any capacity less than 15 would require more ships.
 *
 * Constraints:
 * - 1 <= k <= weights.length <= 5 * 10^4
 * - 1 <= weights[i] <= 500
 *
 * ------------------------------------------------
 * 💡 Approach:
 * - The answer (ship capacity) must be between max(weights) and sum(weights).
 * - If a capacity 'C' works, any capacity > 'C' also works (Monotonicity).
 * - Use Binary Search to find the smallest 'C' that satisfies the condition.
 *
 * [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 * here the capacity of the truck  must me = 10 or greater because if we took a capacity < 10 like 9,8 that mean it is
 * impossible to carry weight 10 becaue we are taking capacity wihich is lower than 10 so because of this scenario
 * we have to take the capacity greater than the highest weight in the array
 *
 * so this highest weight in the array becomes the lowerbound for the search space and the totalsum of all the weights in the array
 * becames the upperbound for the search space
 * lowerbound =10 ;upperbound=55
 *
 *
 * ------------------------------------------------
 * OPTIMAL:
 * ⏱ Time Complexity  : O(n * log(Sum of Weights))
 * 🗂 Space Complexity : O(1)
 *
 * ================================================================
 */



public class MinmaxLoad {
    public static void main(String[] args) {
        System.out.println( minimumMaxLoad(new int[]{2,4,6,8,10},2));

    }
    public static int minimumMaxLoad(int[] weights, int k) {
        // Step 1: Define your search space (low and high)

        int Upperbound = 0;
        int lowerbound=Integer.MIN_VALUE;
        for(int i:weights)
        {
            Upperbound +=i;
            lowerbound = Math.max(lowerbound,i);
        }
        // low should be the heaviest single package
        // high should be the sum of all packages

        int low = lowerbound;
        int high = Upperbound;
        // Step 2: Perform Binary Search
        while (low<=high)
        {
            int mid = low+(high-low)/2;
// Step 3: Write a helper function 'canShip(capacity)' to check
            // if weights can be split into k or fewer ships with that capacity.
            int No_of_ships=shipcounter(weights,mid);
            if(No_of_ships<= k)
            {
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }



        // Step 3: Write a helper function 'canShip(capacity)' to check
        // if weights can be split into k or fewer ships with that capacity.

        return low; // Placeholder
    }

    private static int shipcounter(int[] weights, int mid) {

        int no_of_ships = 1;
        int currentload =0;

        for(int w:weights)
        {
            if(currentload+w<=mid)
            {
                // It fits! Keep adding to the same ship
                currentload += w;
            }
            else {
                // It doesn't fit. This ship is full.
                // Call a new ship and put the weight in it.

                no_of_ships++;
                currentload=w;

            }
        }
        return no_of_ships;
    }

}
