import java.util.*;

public class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        int ans = 0;

        // Sort by x ascending, and then y descending
        Arrays.sort(points, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(b[1], a[1]);  // higher y first if x same
        });

        // For each point i, look forward for valid pairs
        for (int i = 0; i < n; i++) {
            int maxY = Integer.MIN_VALUE;
            for (int j = i + 1; j < n; j++) {
                if (points[i][1] >= points[j][1] && points[j][1] > maxY) {
                    ans++;
                    maxY = points[j][1];
                }
            }
        }

        return ans;
    }
}
