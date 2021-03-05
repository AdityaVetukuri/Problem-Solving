import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Solution {
    public static int availableSpace(List<Integer> freeSpace, int blockLength) {
        int maximum = Integer.MIN_VALUE;
        int minimum_size = 0;
        int start = 0;
        int end = 0;
        for(int i=0; i<blockLength; i++)
        {
            minimum_size = minimum_size + freeSpace.get(i);
        }
        start = 0;
        end = blockLength -1;
        int updateSize = minimum_size;
        for(int i = blockLength; i < freeSpace.size(); i++)
        {
           updateSize = updateSize + freeSpace.get(i) - freeSpace.get(i-blockLength);
           if(updateSize < minimum_size)
           {
               start = i - blockLength +1;
               end = i;
               minimum_size = updateSize;
           }

        }
        for(int i = start; i<=end; i++)
        {
            if(maximum < freeSpace.get(i))
            {
                maximum = freeSpace.get(i);
            }
        }
        return maximum;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> freeSpace = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int blockLength = Integer.parseInt(scanner.nextLine());
        scanner.close();
        int res = availableSpace(freeSpace, blockLength);
        System.out.println(res);
    }
}
