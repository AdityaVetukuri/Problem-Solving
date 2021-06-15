import java.util.*;
class MaximumAveragePassRatio1792 {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> queue = new PriorityQueue<>(new Comparator<double[]>(){
            @Override
            public int compare(double[] a, double[] b) {
                if (a[0] > b[0]) {
                    return -1;
                } else if (a[0] < b[0]) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        for (int[] c : classes) {
            queue.offer(new double[]{willGain(c[0] * 1.0, c[1] * 1.0), c[0] * 1.0, c[1] * 1.0});
        }
        while (extraStudents-- > 0) {
            double[] top = queue.poll();
            top[1]++;
            top[2]++;
            top[0] = willGain(top[1], top[2]);
            queue.offer(top);
        }
        double sum = 0.0;
        int n = queue.size();
        while (!queue.isEmpty()) {
            double[] top = queue.poll();
            sum += ratio(top[1], top[2]);
        }
        return sum / n;
    }

    public double willGain(double pass, double total) {
        return ratio(pass + 1, total + 1) - ratio(pass, total);
    }

    public double ratio(double pass, double total) {
        return pass / total;
    }
}