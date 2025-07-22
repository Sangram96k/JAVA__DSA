package Com.sangram.JAVA_DSA;

public class unionOFTwoArray {
/*
* Given and nums array of length n you want to create a array of length 2n where ans[i]==nums[i]
* and ans[n+i]=nums[i];
*
* */

    public static int[] concat(int[] nums)
    {
        int n = nums.length;
        int[] ans = new int[n*2];

        for (int i=0;i<n;i++)
        {
            ans[i]=nums[i];
        }

        for (int i=0;i<n;i++)
        {
            ans[n+i] = nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr={2,3,4,5,6};
int[] ans = concat(arr);
        for (int val:ans){
            System.out.println("Union or the concatination of the array is : "+val);
        }

    }
}

/*



 we can use the inbuilt methods also
*  int[] arr1 = {1, 2, 3};
        int[] arr2 = {4, 5, 6};

        // Create a new array of combined size
        int[] merged = new int[arr1.length + arr2.length];

        // ---- Copy arr1 into merged ----
        // Syntax: System.arraycopy(source, sourceIndex, destination, destIndex, length);
        System.arraycopy(arr1, 0, merged, 0, arr1.length);
        // Copies arr1[0..2] into merged[0..2]

        // ---- Copy arr2 into merged, starting after arr1's last element ----
        System.arraycopy(arr2, 0, merged, arr1.length, arr2.length);
        // Copies arr2[0..2] into merged[3..5]

* */
