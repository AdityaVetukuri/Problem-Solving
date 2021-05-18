import java.util.PriorityQueue;

class Memory
{
    int value;
    int memory;
    Memory(int value, int memory)
    {
        this.value = value;
        this.memory = memory;
    }
}
public class BiWeeklyContest52 {
    public static String sortSentence(String s) {
        String[] str = s.split(" ");
        String[] res = new String[str.length];

        for(int j = 0; j < str.length; j++)
        {
            String temp = str[j];

            String ans = "";

            for(int i = 0; i < temp.length(); i++)
            {
                if(Character.getNumericValue(temp.charAt(i)) > 0 && (int) Character.getNumericValue(temp.charAt(i)) < 10)
                {
                    res[(int) Character.getNumericValue(temp.charAt(i)) - 1] = ans;
                }
                else
                {
                    ans += temp.charAt(i);
                }
            }
        }
        String result = "";
        for(int i = 0; i < res.length; i++)
        {
            if(i!= res.length -1)
            result += res[i] + " ";
            else
                result += res[i];
        }

        return result;
    }
    private static int[] memoryLeak(int memory1, int memory2) {
        boolean flag = true;
        int req = 1;
        Memory m1 = new Memory(1,memory1);
        Memory m2 = new Memory(2,memory2);

        while(flag)
        {
            if(req > Math.max(m1.memory, m2.memory))
                break;
            if(m1.memory >= m2.memory)
            {
                m1.memory = m1.memory - req;
            }
            else
            {
                m2.memory = m2.memory - req;
            }
            req++;
        }
        return new int[]{req, m1.memory, m2.memory};
    }
    private static char[][] rotateTheBox(char[][] box) {

        char res[][] = new char[box[0].length][box.length];

        for(int i = 0; i < box.length; i++)
        {
            int lastSeen = -1;
            for(int j = 0; j < box[i].length; j++)
            {
                if(box[i][j] == '.')
                {
                    if(lastSeen != -1) {
                        swap(lastSeen, j, box[i]);
                        lastSeen++;
                    }
                }
                else if(box[i][j] == '*')
                {
                    lastSeen = j + 1;
                }
                else
                {
                    if(lastSeen == -1)
                        lastSeen = j;
                }
            }
        }
     res = rotate(box);
    return res;
    }
    public static char[][] rotate(char[][] matrix) {

            if (matrix == null || matrix.length == 0) {
                // Nothing to do. Invalid input.
                return matrix;
            }

            int m = matrix.length;
            int n = matrix[0].length;

            char[][] rotatedArray = new char[n][m];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    rotatedArray[j][m-i-1] = matrix[i][j];
                }
            }
        return rotatedArray;
    }

    private static void swap(int lastSeen, int j, char[] box) {
        char temp = ' ';

        temp = box[lastSeen];
        box[lastSeen] = box[j];
        box[j] = temp;
    }

    public static void main(String[] args) {
        String str = "Myself2 Me1 I4 and3";
        int memory1 = 9;
        int memory2 = 6;
//        memoryLeak(memory1, memory2);
//        sortSentence(str);

        char[][] box = new char[][]{{'#','#','*','.','*','.'},
        {'#','#','#','*','.','.'},
        {'#','#','#','.','#','.'}};

        rotateTheBox(box);
    }




}
