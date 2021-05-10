import java.util.*;
public class maximumScoresRemovingSub {
    public static int maximumGain(String s, int x, int y) {
        int ac = 0;
        int bc = 0;
        int res = 0;
        for(char c : s.toCharArray()){
            if(c == 'a'){
                ac++;
                if(x < y && bc > 0){
                    res += y;
                    ac--;
                    bc--;
                }
            }else if(c == 'b'){
                bc++;
                if(x > y && ac > 0){
                    res += x;
                    ac--;
                    bc--;
                }
            }else{
                res += Math.min(x, y) * Math.min(ac, bc);
                ac = 0;
                bc = 0;
            }
        }
        res += Math.min(x, y) * Math.min(ac, bc);
        return res;
    }

    public static void main(String[] args) {
        String str = "cdbcbbaaabab";
        int x = 4;
        int y = 5;
        System.out.println(maximumGain(str,x,y));
    }
}
