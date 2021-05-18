import java.util.PriorityQueue;

class Student
{
    double passed;
    double students;
    double average;
    int priority;
    Student(int passed, int students)
    {
        this.passed = passed;
        this.students = students;
        this.average = (double) passed / students;
        this.priority = (int)average * 100;
    }
}

public class MaximumAveragePassRatio1792 {
    public double maxAverageRatio(int[][] classes, int extraStudents) {

        // max heap, the root not is the Room with the largest change
        PriorityQueue<Room> maxHeap = new PriorityQueue<>(classes.length, (a,b) -> Double.compare(b.fetchRatio(),a.fetchRatio()));

        // for each class, add create a room and add to the maxHeap
        for(int[] arr : classes){
            Room room = new Room(arr[0], arr[1]);
            maxHeap.offer(room);
        }

        // for each extra student, get the one that would have the highest change
        // and increment its pass and total by 1
        for(int i = 0; i < extraStudents; i++){
            Room room = maxHeap.poll();
            room.pass++;
            room.total++;
            maxHeap.offer(room);
        }


        double total = 0;

        // go through each room in heap and fetch the quotient
        while(maxHeap.peek() != null){
            Room room = maxHeap.poll();
            total += room.fetchQuotient();
        }
        return total / classes.length;

    }
    public static void main(String[] args) {
        int[][] classes = new int[][]{{1,2},{3,5},{2,2}};
        int extraStudents = 2;
        maxAverageRatio(classes, extraStudents);

    }
}
