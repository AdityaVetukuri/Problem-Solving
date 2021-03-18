class MinimumDeletions {
    public int minimumDeletions(String s) {
        int a = 0 , b = 0 ,cnt = 0;
        for(char c : s.toCharArray()){
            if(c == 'a'){
                if(b == 0)
                    continue ;
                a++;
                if(a > b){
                    cnt += b ;

                    a = 0;
                }
            }
            else
                b++;
        }
        cnt += a;
        return cnt ;
    }
}