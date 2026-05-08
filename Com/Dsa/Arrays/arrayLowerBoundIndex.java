package Com.sangram.DSA.Com.Dsa.Arrays;

public class arrayLowerBoundIndex {



    public static int lowerbound(int[] arr,int x) {

        int low = 0;
        int high= arr.length-1;
        int ans= arr.length;

        while (low<=high)
        {

            int mid = low+(high-low)/2;

            if (arr[mid]>=x)
            {
                ans=mid;
                high=mid-1;

            }
            else {
                low=mid+1;
            }

        }

        return ans;
    }

    public static void main(String[] args) {
       int[] arr =  new int[]{1,2,3,4,6,6};


       int ansupper = upperbound(arr,3);


       int ans =  lowerbound(new int[]{1,2,3,4,2,6,6,2},4);
        System.out.println(ansupper);
    }



//    smallest index such that the arr[i]>x;
    private static int upperbound(int[] arr, int i) {
        int low = 0;
        int high= arr.length-1;
        int ans = arr.length;

        while (low<=high)
        {
            int mid = low+(high-low)/2;

            if(arr[mid]>i)
            {
                ans=mid;
                high=mid-1;

            }
            else{
             low = mid+1;
            }

        }

      return  ans;
    }
}
