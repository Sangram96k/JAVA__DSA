package Com.sangram.DSA.Com.Dsa.Arrays;




public class occurenceOfNumber {
    public static void main(String[] args) {
        int[] arr = new int[] {1,1,2,2,2,4,5};

//         Brute-fore logic
       int ans=  occurrenceOfnumber(new int[] {1,1,2,2,2,4,5},2);

        System.out.println(ans);
    }

    public static int  occurrenceOfnumber(int[] arr, int target) {
        int first =   first(arr,target);
        if (first ==0 )
        {
             return  0;

        }
          int last =last(arr,target);
       int ans = (last-first)+1;
          return ans ;

    }

    private static int last(int[] arr, int target) {

        int last =-1;
        int low =0;
        int high = arr.length-1;
        while (low<=high)
        {
            int mid = low + (high - low) / 2;

            if(arr[mid]==target)
            {
                last = mid;
                low = mid+1;

            }
            else if (target>arr[mid])
            {
                low=mid+1;
            }
            else{
                high = mid-1;
            }

        }
        return last;
    }

    private static int first(int[] arr, int target) {
        int first=-1;
        int low=0;
        int high = arr.length-1;

        while (low<=high)
        {
            int mid = low + (high - low) / 2;

            if(arr[mid]==target)
            {
                first = mid;
                high = mid-1;

            } else if (target>arr[mid]) {
                low=mid+1;


            }
            else {
                high = mid-1;
            }
        }
        return first;
    }
}
