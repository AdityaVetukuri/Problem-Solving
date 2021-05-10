class SmallestLetter {
    public static char nextGreatestLetter(char[] letters, char target) {
        int smallest = letters.length-1;
        for(int i = 0; i < letters.length; i++)
        {
            if((int) target < (int) letters[i])
            {
                smallest = Math.min(smallest, i);
            }
        }
        return letters[smallest];
    }

    public static void main(String[] args) {
        char[] letters = new char[]{'c', 'f', 'j'};
        char target = 'c';
        System.out.println(nextGreatestLetter(letters, target));
    }
}