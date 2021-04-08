import java.util.*;
class RangeSumSortedSub {
    int arr[];
    int k=0,mod=1000000007;
    void findSum(int length,int nums[]){
        int subarraySum=0,i=0;
        for(int j=0;j<nums.length;j++){
            subarraySum+=nums[j];
            if(j-i+1>length)
                subarraySum-=nums[i++];
            if(j-i+1==length)
                arr[k++]=subarraySum;
        }
        return ;
    }
    public int rangeSum(int[] nums, int n, int left, int right) {
        arr=new int[n*(n+1)/2];
        for(int l=1;l<=nums.length;l++)
            findSum(l,nums);
        Arrays.sort(arr);
        int sum=0;
        for(int i=left-1;i<right;i++)
            sum=(sum+arr[i])%mod;
        return sum;
    }
}