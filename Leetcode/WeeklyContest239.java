import java.util.PriorityQueue;

class smallestString
{
    String str;
    int Priority;
    smallestString(String str, int Priority)
    {
        this.str = str;
        this.Priority = Priority;
    }
}
public class WeeklyContest239 {
    public static int getMinDistance(int[] nums, int target, int start) {
        int absMinimum = Integer.MAX_VALUE, value = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == target)
            {
                value = Math.abs(i - start);
                if(absMinimum >= value)
                {
                    absMinimum = value;
                }
            }
        }
        return absMinimum;
    }


            public static int getMinSwaps(String num, int k) {
                char[] temp = num.toCharArray();

                for(int i = 0; i < k; i++)
                    nextPermutation(temp);

                return count(num.toCharArray(), temp, temp.length);
            }
            public  static void nextPermutation(char[] a) {
                int i = a.length - 2;
                //Find the first element which isn't in increasing order fom behind
                while (i >= 0 && a[i] >= a[i + 1])
                    i--;
                //If we found an element
                if (i >= 0){
                    // Find the rightmost element such that a[j] > a[i]
                    int j = bSearch(a, i + 1, a.length - 1, a[i]);
                    // swap a[i] and a[j]
                    a[i] = (char)(a[i] ^ a[j] ^ (a[j] = a[i]));
                }
                //reverse array from i + 1 till end
                reverse(a, i + 1, a.length - 1);
            }

            public static int bSearch(char a[], int i, int j, char key) {
                while (i <= j) {
                    int mid = (i + j) >>> 1;

                    if (key < a[mid])
                        i = mid + 1;
                    else
                        j = mid - 1;
                }
                return i - 1;
            }

            public static void reverse(char[] a, int i, int j) {
                while(i < j)    a[i] = (char)(a[i] ^ a[j] ^ (a[j--] = a[i++]));
            }

            static int count(char []s1, char[] s2, int n) {
                int i = 0, j = 0, res = 0;

                while (i < n) {
                    j = i;

                    while (s1[j] != s2[i]) j++;

                    while (i < j) {
                        char temp = s1[j];
                        s1[j] = s1[j - 1];
                        s1[j-- - 1] = temp;
                        ++res;
                    }
                    ++i;
                }
                return res;
            }
    public static void main(String[] args) {
//        int[] arr = new int[]{1,2,3,4,5};
//        getMinDistance(arr , 5, 3);

          String str = "5489355142";
          int k = 4;
          getMinSwaps(str, k);


    }
}
