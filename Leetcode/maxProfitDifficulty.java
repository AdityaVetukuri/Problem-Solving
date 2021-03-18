import java.util.*;
class maxProfitDifficulty {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int max = 0;
        for(int i: difficulty) {                  //First we try to get the max values of the arrays difficulty, worker
            max = Math.max(max,i);
        }
        for(int i: worker) {
            max = Math.max(max,i);
        }
        int[] bucket = new int[max+1];                //Create an array of the size of max+1
        Arrays.fill(bucket,0);
        for(int i=0;i<difficulty.length;i++) {                      //Fill the bucket indexed difficulty and value is respective profit of that difficulty                                          
            bucket[difficulty[i]] = Math.max(profit[i],bucket[difficulty[i]]) ;
        }
        max = 0;
        for(int i=0;i<bucket.length;i++) {                       //fill the bucket according to the previous max values
            bucket[i] = Math.max(max,bucket[i]);
            max = Math.max(max,bucket[i]);
        }
        int res = 0;
        for(int i: worker) {
            res+=bucket[i];
        }
        return res;
    }
}