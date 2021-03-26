class removeKdigits {
    public String removeKdigits(String num, int k) {
        StringBuilder str=new StringBuilder();
        for(char c : num.toCharArray()){
            while(str.length()>0&&str.charAt(str.length()-1)>c&&k-->0) str.deleteCharAt(str.length()-1);
            str.append(c);
        }
        while(k-->0)  str.deleteCharAt(str.length()-1);
        while(str.length()>0&&str.charAt(0)=='0')str.deleteCharAt(0);
        return str.length()==0 ? "0" :  str.toString();
    }
}
