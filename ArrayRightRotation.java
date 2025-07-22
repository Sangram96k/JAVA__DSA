package Com.sangram.DSA;
//# Given an integer array `nums`, rotate the array to the right by `k` steps.
//# The value of `k` is non-negative.
//#
//        # Example 1:
//        # Input: nums = [1, 2, 3, 4, 5, 6, 7], k = 3
//        # Output: [5, 6, 7, 1, 2, 3, 4]
//        # Explanation:
//        # After 1 step right rotation: [7, 1, 2, 3, 4, 5, 6]
//        # After 2 steps: [6, 7, 1, 2, 3, 4, 5]
//        # After 3 steps: [5, 6, 7, 1, 2, 3, 4]
//        #
//        # Example 2:
//        # Input: nums = [-1, -100, 3, 99], k = 2
//        # Output: [3, 99, -1, -100]
//        # Explanation:
//        # After 1 step right rotation: [99, -1, -100, 3]
//        # After 2 steps: [3, 99, -1, -100]
//        #
//        # Your task is to write a function that rotates the array `nums` to the right byy `k` positions.

public class ArrayRightRotation {
    public void rotate(int[] arr ,int k)
    {
        int n = arr.length;
        k=k%n;// if k is greater that n
        if (k==0) return;

        reverse(arr,0,n-1);
        reverse(arr,0,k-1);
        reverse(arr,k,n-1);



    }

    public static  void reverse(int[] arr,int start,int end)
    {
        while (start<end)
        {
            int temp = arr[start];
            arr[start] =arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }



    public static void main(String[] args) {
int [] arr = {1,2,3,4,5,6};

ArrayRightRotation r = new ArrayRightRotation();

r.rotate(arr,3);

        for(int val:arr){
            System.out.println(val);
        }
    }


}
