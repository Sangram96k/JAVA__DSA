package Com.sangram.DSA;

public class ArrayLeftRotation extends ArrayRightRotation {
   @Override
    public  void rotate(int[] arr,int k){
       int n= arr.length;
       k=k%n;
       if (k==0)
           return;;

           reverse(arr,0,k-1);
           reverse(arr,k,n-1);
           reverse(arr,0,n-1);

    }


    public static void main(String[] args) {
int[] arr = {1,2,3,4,5,6};
       ArrayLeftRotation L = new ArrayLeftRotation();
       L.rotate(arr,3);

       for (int key :arr)
       {
           System.out.println(key);
       }
    }

}
