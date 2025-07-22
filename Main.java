package Com.sangram.DSA;

import java.util.Arrays;

public class Main  {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int[] Larr = Arrays.copyOf(arr,arr.length);
        int[] Rarr = Arrays.copyOf(arr,arr.length);

        ArrayLeftRotation L = new ArrayLeftRotation();
        ArrayRightRotation R=new ArrayRightRotation();
        R.rotate(Rarr,4);
        L.rotate(Larr,3);

        for (int key :Rarr)
        {
            System.out.println("The right rotation"+key);
        }

        System.out.println();
        for (int val:Larr)
        {
            System.out.println("left rotation of the array:"+val);
        }
    }
}
