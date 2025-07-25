package Com.sangram.JAVA_DSA;

/*
Problem Statement: Finding the Missing Number
#
# Given an integer array 'nums' of size 'n' containing distinct values
# in the range from 0 to n (inclusive), return the only number missing
# from the array within this range.
#
# Examples:
#
# Input: nums = [0, 2, 3, 1, 4]
# Output: 5
# Explanation: The array 'nums' contains 0, 1, 2, 3, 4.
# The expected range is [0, 5] (since n = 5).
# The missing number in this range is 5.
#
# Input: nums = [0, 1, 2, 4, 5, 6]
# Output: 3
# Explanation: The array 'nums' contains 0, 1, 2, 4, 5, 6.
# The expected range is [0, 6] (since n = 6).
# The missing number in this range is 3.
*/
public class MissingNumber {

    // There are various ways but i am doing it in
    // 1. Bruteforce solution
    public static void findmissing(int[] arr) {
        int missingnumber = 0;
        int n = arr.length; // 'n' here represents the length of the input array.

        // This outer loop iterates through numbers from 1 up to (n-1).
        // It attempts to find a missing number within this specific sub-range.

        for (int i = 1; i < n; i++) {
            boolean flag = true; // Flag to indicate if 'i' is found in the array.

            // This inner loop iterates through the first (n-1) elements of the input array 'arr'.
            // It checks if the current number 'i' (from the outer loop) is present in 'arr'.
            // Note: This loop might not check the last element of the 'arr' if 'n' is arr.length.
            for (int j = 0; j < n - 1; j++) {
                if (arr[j] == i) {
                    flag = false; // If 'i' is found, set flag to false.
                    break; // No need to check further for this 'i'.
                }
            }
            // If the flag is still true after checking the array, it means 'i' was not found
            // in the checked portion of the array, and thus is considered missing.
            if (flag) {
                missingnumber = i; // Stores 'i' as the missing number.
                // If multiple numbers are missing in the 1 to n-1 range,
                // this will store the last one found.
            }
        }
        System.out.println("the missing value is :" + missingnumber);
    }

    // Optimal solution using the mathematical formula
    public static int find(int[] arr) {
        int n = arr.length; // 'n' here represents the length of the input array.

        // Calculates the sum of an arithmetic series from 1 to 'n'.
        // This formula (n*(n+1)/2) is for the sum of numbers from 1 to 'n'.
        // It implicitly assumes the complete sequence is from 1 to 'n' (where 'n' is arr.length)
        // and that one number is missing from this range.
        // Note: This does not account for the number 0 being part of the expected range
        // as per the problem statement [0, n].
        int Expectedsum = n * (n + 1) / 2;
        int actualsum = 0;

        // This loop sums the first (n-1) elements of the input array 'arr'.
        // Note: It will skip the last element of the array, arr[n-1].
        for (int i = 0; i < n - 1; i++) {
            actualsum += arr[i];
        }

        // The difference between the expected sum (1 to n) and the actual sum
        // of the first (n-1) elements of the array is returned as the missing number.
        int missingnumber = Expectedsum - actualsum;
        return missingnumber;
    }


    // Optimal solution using the XOR property
    public static int findxor(int[] arr) {
        int fullxor = 0; // Accumulator for XOR of the complete expected range.
        int xorarr = 0;  // Accumulator for XOR of numbers present in the array.

        // This loop calculates the XOR sum of all numbers from 1 up to (arr.length + 1).
        // This logic assumes that the complete sequence of numbers should range from 1
        // to (arr.length + 1), and exactly one number is missing from this range.
        // For example, if arr.length is 5, it XORs 1, 2, 3, 4, 5, 6.
        // Note: This method does not account for the number 0 being part of the expected range
        // as per the problem statement [0, n].
        for (int i = 1; i <= arr.length + 1; i++) {
            fullxor ^= i;
        }

        // This loop calculates the XOR sum of all numbers currently present in the input array 'arr'.
        for (int val : arr) {
            xorarr ^= val;
        }

        // The missing number is found by XORing the 'fullxor' (XOR of complete range)
        // with 'xorarr' (XOR of present numbers).
        // The property of XOR (A^B^B = A) ensures that all numbers present in both
        // 'fullxor' and 'xorarr' cancel out, leaving only the missing number.
        int missingnumber = fullxor ^ xorarr;
        return missingnumber;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6}; // Example array for testing

        // Calls the bruteforce method and prints its result.
        findmissing(arr);

        // Calls the mathematical formula method and prints its result.
        int number = find(arr);
        System.out.println(number);

        // Calls the XOR method and prints its result.
        System.out.println(findxor(arr));
    }

}
