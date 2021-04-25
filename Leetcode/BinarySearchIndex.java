import java.io.*;
import java.util.*;

// left - > right index , arr[index]

//  [-8,0,1,3,5] low = 0, end = 5;

//mid = 1 index = 2
class BinarySearchIndex {

    static int indexEqualsValueSearch(int[] arr) {
        // your code goes here


        int low = 0;
        int end = arr.length -1;


        return binarySearch(arr, low, end);
    }

    static int binarySearch(int arr[], int low, int end)
    {
        int mid = low + (end - low) / 2;
        if(low >= end)
            return -1;
        if(mid == arr[mid])
        {
            return mid;
        }
        else if(arr[mid] > mid)
        {
            return binarySearch(arr, low, mid-1);
        }
        else
        {
            return binarySearch(arr, mid+1, end);
        }

    }


    public static void main(String[] args) {
        int arr[] = new int[]{-2,-3,0,3,4};

        System.out.println("Min Index :" + indexEqualsValueSearch(arr));
    }

}