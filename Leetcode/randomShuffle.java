import java.util.*;
class randomShuffle {
    int[] array;
    int[] temp;
    public randomShuffle(int[] nums) {
        array = new int[nums.length];
        temp = new int[nums.length];
        this.array = nums;
        for(int i=0; i<array.length; i++) {
            temp[i] = array[i];
        }
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {

        return  temp;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int index;
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--)
        {
            index = random.nextInt(i + 1);
            if (index != i)
            {
                array[index] ^= array[i];
                array[i] ^= array[index];
                array[index] ^= array[i];
            }
        }
        return array;
    }
}
