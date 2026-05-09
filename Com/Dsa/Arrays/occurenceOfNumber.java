package Com.sangram.DSA.Com.Dsa.Arrays;


import static Com.sangram.DSA.Com.Dsa.Arrays.firstAndLastOccuranceOfNumber.first;
import static Com.sangram.DSA.Com.Dsa.Arrays.firstAndLastOccuranceOfNumber.last;

public class occurenceOfNumber {
    public static void main(String[] args) {
        int[] arr = new int[] {1,1,2,2,2,4,5};

//         Brute-fore logic
       int ans=  occurrenceOfnumber(arr,2);

        System.out.println(ans);
    }

    public static int  occurrenceOfnumber(int[] arr, int target) {
        int first =   first(arr,target);
          int last =last(arr,target);
       int ans = first-last;
          return last;

    }
}
