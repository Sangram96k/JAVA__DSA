package Com.sangram.JAVA_DSA;

public class MoveZeroToEnd {
    public static void movetoend(int[] arr){
        int pos =0;
        int n =arr.length;
        for (int i=0;i<n;i++)
        {
            if (arr[i]!=0)
            {
                arr[pos]=arr[i];
                pos++;
            }
        }
while (pos<n)
{
    arr[pos] =0;
    pos++;
}
    }

    public static void main(String[] args) {
        int[] arr = {1,2,0,2,0,4,3,0};

        movetoend(arr);

        for (int val:arr){
            System.out.println("All zeros are in the end"+val);
        }
    }



}
