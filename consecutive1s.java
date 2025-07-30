package Com.sangram.JAVA_DSA;

public class consecutive1s {

    public static int cons(int[] arr){

        int n  = arr.length;
        int count =0;
        int maxxons = 0;
        for (int i=0;i<n;i++)
        {
            if (arr[i]==1)
            {
                count++;

                if (count>maxxons)
                {
                    maxxons=count;

                }
            }

            else if (arr[i]==0){
                count= 0;
            }

        }
        return maxxons;
    }

    public static void main(String[] args) {
        int[] arr = {1,0,1,1,1,0,0,1};//[]
        System.out.println(cons(arr));
    }
}
