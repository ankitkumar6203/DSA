import java.util.PriorityQueue;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // Max heap: store by the gain if we add 1 student
        PriorityQueue<double[]> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(b[0], a[0])
        );

        // Initialize heap with gain and current values
        for (int[] c : classes) {
            int pass = c[0], total = c[1];
            double gain = getGain(pass, total);
            pq.offer(new double[]{gain, pass, total});
        }

        // Distribute extra students
        while (extraStudents-- > 0) {
            double[] cur = pq.poll();
            int pass = (int) cur[1], total = (int) cur[2];
            pass++;
            total++;
            double gain = getGain(pass, total);
            pq.offer(new double[]{gain, pass, total});
        }

        // Compute final average ratio
        double sum = 0.0;
        while (!pq.isEmpty()) {
            double[] cur = pq.poll();
            sum += cur[1] / cur[2];
        }

        return sum / classes.length;
    }

    // Helper function: calculates gain
    private double getGain(int pass, int total) {
        return (double)(pass + 1) / (total + 1) - (double) pass / total;
    }
}
