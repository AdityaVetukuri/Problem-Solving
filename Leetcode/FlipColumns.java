import java.util.*;
class FlipColumns {
    public static int maxEqualRowsAfterFlips(int[][] matrix) {
        HashMap<String,Integer> mp = new HashMap();
        for(int i=0;i<matrix.length;i++) {
            String[] t = isP(matrix[i]);
            mp.put(t[0],mp.getOrDefault(t[0],0)+1);
            mp.put(t[1],mp.getOrDefault(t[1],0)+1);
        }
        int ans=1;
        for(String a : mp.keySet())
            ans = Math.max(ans,mp.get(a));
        return ans;
    }
    private static String[] isP(int[] a){
        String o = "";
        String p = "";
        for(int i: a) {
            o+=i==1?"1":"0";
            p+=i==1?"0":"1";
        }
        return new String[]{o,p};
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0,0,0},{0,0,1},{1,1,0}};
        maxEqualRowsAfterFlips(matrix);
    }
}