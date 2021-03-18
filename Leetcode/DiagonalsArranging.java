import java.util.*;
public class DiagonalsArranging {
    public String temp = "";
    public static void main(String args[])
    {
        char[][] matrix = new char[][]{{'a','c','a','b','b'},{'c','b','a','c','b'},{'a','a','e','c','b'},{'b','b','d','a','g'},{'a','b','e','b','a'}};
        diagonalArrangin(matrix,matrix.length);
    }

    private static int[] diagonalArrangin(char[][] matrix,int n) {
      TreeMap<String, Integer> map = new TreeMap<>();
      int diagonal = 1;
      for(int i =matrix.length-1;i>=0; i--)
      {
          int j =0;
          String temp = "";
          int k = i;
          while(k < matrix.length)
          {
              temp += matrix[k][j];
              k++;
              j++;
          }
          if(temp.length() < matrix.length)
              temp = temp + temp.repeat(matrix.length-temp.length()).substring(0, matrix.length-1);
          map.put(temp,diagonal);
          diagonal++;
      }
      for(int j = 1; j< matrix[0].length;j++)
      {
          int i =0;
          String temp = "";
          int k=j;
          while(k< matrix[0].length)
          {
              temp += matrix[i][j];
              k++;
              i++;
          }
          if(temp.length() < matrix.length)
              temp = temp + temp.repeat(matrix.length-temp.length());
              temp = temp.substring(0, matrix.length-1);
          map.put(temp,diagonal);
          diagonal++;
      }
      int arr[] = new int[map.size()];
      int i =0;
        for (Map.Entry<String, Integer>
                entry : map.entrySet())
        {
            arr[i] = entry.getValue();
            i++;
        }
        return arr;
    }
}
