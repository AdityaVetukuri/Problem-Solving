import java.util.*;
public class RobotBound1041 {
    public static void main(String[] args) {
        String instructions = "GGLLGG";
        boolean flag = isRobotBounded(instructions);
    }
    public static boolean isRobotBounded(String instructions)
    {
        int direction = 90, x = 0, y = 0;
        for(char c : instructions.toCharArray())
        {
            switch(c)
            {
                case 'G':
                    if(direction == 90) y+=1;
                    if(direction == 180) x+=1;
                    if(direction == 270) y-=1;
                    if(direction == 0) x-=1;
                    break;
                case 'L':
                    direction = Math.floorMod(direction - 90, 360);
                    break;
                case 'R':
                    direction = Math.floorMod(direction + 90, 360);
                    break;
            }
        }
        return (x == 0 && y == 0) || direction != 90;

    }
}
