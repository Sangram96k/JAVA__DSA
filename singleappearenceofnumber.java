package Com.sangram.JAVA_DSA;

import java.util.HashMap;
import java.util.Map;

public class singleappearenceofnumber {
     public static  void singlenumber(int[] arr){
         for (int i=0;i<arr.length;i++){
             int num = arr[i];
             int count = 0;
             for (int j=0;j< arr.length;j++){
                 if (arr[j]==num)
                 {
                     count++;
                 }
             }
             if (count ==1){
                 System.out.println("first method"+num);
             }
         }

     }
public static int single(int[] arr)
{
    /**
     * This part of the code iterates through the input array nums. Its goal is to create a frequency map, which is a HashMap where:
     *
     * The key is a number from the array.
     *
     * The value is how many times that number appears (its frequency).
     *
     * Let's use the example nums = [1, 2, 2, 4, 3, 1, 4]. The loop would do the following:
     *
     * num = 1: The map is empty. freqMap.getOrDefault(1, 0) returns 0. The map becomes {1=1}.
     *
     * num = 2: freqMap.getOrDefault(2, 0) returns 0. The map becomes {1=1, 2=1}.
     *
     * num = 2: freqMap.getOrDefault(2, 0) returns 1. The map becomes {1=1, 2=2}.
     *
     * num = 4: freqMap.getOrDefault(4, 0) returns 0. The map becomes {1=1, 2=2, 4=1}.
     *
     * num = 3: freqMap.getOrDefault(3, 0) returns 0. The map becomes {1=1, 2=2, 4=1, 3=1}.
     *
     * num = 1: freqMap.getOrDefault(1, 0) returns 1. The map becomes {1=2, 2=2, 4=1, 3=1}.
     *
     * num = 4: freqMap.getOrDefault(4, 0) returns 1. The map becomes {1=2, 2=2, 4=2, 3=1}.
     *
     * After the loop finishes, the freqMap is {1=2, 2=2, 4=2, 3=1}. This map correctly shows that the numbers 1, 2, and 4 each appear twice, while the number 3 appears once.
     */
    Map<Integer,Integer> freqmap = new HashMap<>();
    for (int num:arr)
    {
        freqmap.put(num,freqmap.getOrDefault(num,0)+1);
    }

    for (Map.Entry<Integer,Integer> entry:freqmap.entrySet()){
        if (entry.getKey()==1)
        {
            return entry.getKey();
        }
    }
    return -1;
}
    /**
     * The core principle of this approach is based on two key properties of the XOR operation:
     *
     * A number XORed with itself results in 0 (x
     * oplusx=0).
     *
     * A number XORed with 0 results in the number itself (x
     * oplus0=x).
     *
     * Since every number in the array appears twice except for one, XORing all the numbers together will cancel out all the pairs. The only number left will be the one that appears just once.
     *
     * For example, with nums = [1, 2, 2, 4, 3, 1, 4]:
     *
     * (1⊕2⊕2⊕4⊕3⊕1⊕4)
     * We can rearrange the numbers because XOR is commutative and associative:
     *
     * (1⊕1)⊕(2⊕2)⊕(4⊕4)⊕3
     * Which simplifies to:
     *
     * (0)⊕(0)⊕(0)⊕3=3
     * The final result is 3, which is the single number.
     * @param args
     */

public static int singleusignXOR(int[] arr){
         int single = 0;
         for (int num: arr)
         {
             single^=num;
         }

         return single;
}


// using hashing
    public static int hashig(int[] arr)
    {
        // finiding the max value in the arry
        /**
         * The frequency array uses the numbers from the input array as indices.
         * For this to work, the array must be large enough to have an index for every possible number that could appear in the input.
         *
         * For example, if the largest number in your input array is 100, your frequency array needs to have at least 101
         * slots (from index 0 to 100) to store the count for the number 100. If the frequency array were any smaller, trying
         * to access frequency[100] would result in an ArrayIndexOutOfBoundsException.
         */
int maxnum=0;
        for (int num:arr) {
            if (maxnum < num) {
                maxnum = num;

            }
        }
            int[] freq = new int[maxnum+1];//frequency = [0, 0, 0]

            for (int number:arr){
                freq[number]++;
                /**
                 * EXAMPLE: nums = [2, 1, 2]
                 * if First element of arr is: num = 2
                 * The expression frequency[num]++ becomes frequency[2]++. This means:
                 *
                 * Look at the value at index 2 of the frequency array, which is currently 0.
                 *
                 * Increment this value by 1. The value at index 2 is now 1.
                 *
                 * frequency array is now [0, 0, 1].
                 * Second element: num = 1
                 * The expression frequency[num]++ becomes frequency[1]++. This means:
                 *
                 * Look at the value at index 1 of the frequency array, which is currently 0.
                 *
                 * Increment this value by 1. The value at index 1 is now 1.
                 *
                 * frequency array is now [0, 1, 1].
                 *
                 * Third element: num = 2
                 * The expression frequency[num]++ becomes frequency[2]++. This means:
                 *
                 * Look at the value at index 2 of the frequency array, which is currently 1.
                 *
                 * Increment this value by 1. The value at index 2 is now 2.
                 *
                 * frequency array is now [0, 1, 2].
                 */
            }
            for(int i=0;i< freq.length;i++)
            {
                if (freq[i]==1)
                {
                    return freq[i];
                }
        }
            return -1;
    }

    public static void main(String[] args) {
        int[] arr={1};
        singlenumber(arr);
        System.out.println(single(arr));
        //XOR method only works for the one qnique number not for multiple only
        // the first method can work or gives multiple unique number as output
        System.out.println("Xor"+singleusignXOR(arr));
        System.out.println(hashig(arr));

    }
}
