class Solution {
    public long minOperations(int[][] queries) {
        long ans = 0;
        for (int[] q : queries) {
            int l = q[0], r = q[1];
            ans += (getOps(r) - getOps(l - 1) + 1) / 2;
        }
        return ans;
    }

    private long getOps(int n) {
        if (n <= 0) return 0;
        long res = 0;
        int ops = 0;
        long pow4 = 1;

        while (pow4 <= n) {
            int L = (int) pow4;
            int R = Math.min(n, (int) (pow4 * 4 - 1));
            ops++;
            res += (long)(R - L + 1) * ops;
            pow4 *= 4;
        }
        return res;
    }
}
