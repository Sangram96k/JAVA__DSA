package Com.sangram.DSA.Com.Dsa.BinarySearch.BinarySearchOnAnswerPatten;

public class SquareRootOfANumber {
    public static void main(String[] args) {
        System.out.println(squareroot(25));
    }

    public static int  squareroot(int n) {


        int low =1;
        int high = n;
        int ans = 1;

        while(low<=high)
        {
            int mid = low+(high-low)/2;

            if(mid*mid<=n)
            {
                ans = mid;
                low = mid+1;
            }
            else{
                high=mid-1;
            }

        }
     return ans;
    }
}
