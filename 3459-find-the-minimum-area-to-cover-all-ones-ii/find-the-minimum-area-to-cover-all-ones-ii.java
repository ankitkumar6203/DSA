class Solution {
    public int minimumSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans = Integer.MAX_VALUE;

        // Vertical partitions: split into 3 vertical parts
        for (int c1 = 1; c1 < n; c1++) {
            for (int c2 = c1 + 1; c2 < n; c2++) {
                int area1 = areaForRegion(grid, 0, 0, m, c1);
                int area2 = areaForRegion(grid, 0, c1, m, c2);
                int area3 = areaForRegion(grid, 0, c2, m, n);
                ans = Math.min(ans, area1 + area2 + area3);
            }
        }

        // Horizontal partitions: split into 3 horizontal parts
        for (int r1 = 1; r1 < m; r1++) {
            for (int r2 = r1 + 1; r2 < m; r2++) {
                int area1 = areaForRegion(grid, 0, 0, r1, n);
                int area2 = areaForRegion(grid, r1, 0, r2, n);
                int area3 = areaForRegion(grid, r2, 0, m, n);
                ans = Math.min(ans, area1 + area2 + area3);
            }
        }

        // Mixed partitions (one vertical + one horizontal) → "L shaped" splits
        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                // Case 1: Two top rectangles + bottom rectangle
                int area1 = areaForRegion(grid, 0, 0, r, c);
                int area2 = areaForRegion(grid, 0, c, r, n);
                int area3 = areaForRegion(grid, r, 0, m, n);
                ans = Math.min(ans, area1 + area2 + area3);

                // Case 2: Two bottom rectangles + top rectangle
                area1 = areaForRegion(grid, 0, 0, r, n);
                area2 = areaForRegion(grid, r, 0, m, c);
                area3 = areaForRegion(grid, r, c, m, n);
                ans = Math.min(ans, area1 + area2 + area3);

                // Case 3: Two left rectangles + right rectangle
                area1 = areaForRegion(grid, 0, 0, r, c);
                area2 = areaForRegion(grid, r, 0, m, c);
                area3 = areaForRegion(grid, 0, c, m, n);
                ans = Math.min(ans, area1 + area2 + area3);

                // Case 4: Two right rectangles + left rectangle
                area1 = areaForRegion(grid, 0, 0, m, c);
                area2 = areaForRegion(grid, 0, c, r, n);
                area3 = areaForRegion(grid, r, c, m, n);
                ans = Math.min(ans, area1 + area2 + area3);
            }
        }

        return ans;
    }

    // Helper: Find bounding rectangle area covering all 1s in subgrid
    private int areaForRegion(int[][] grid, int r1, int c1, int r2, int c2) {
        int m = grid.length, n = grid[0].length;
        int minR = m, maxR = -1, minC = n, maxC = -1;

        for (int i = r1; i < r2; i++) {
            for (int j = c1; j < c2; j++) {
                if (grid[i][j] == 1) {
                    minR = Math.min(minR, i);
                    maxR = Math.max(maxR, i);
                    minC = Math.min(minC, j);
                    maxC = Math.max(maxC, j);
                }
            }
        }

        if (maxR == -1) return 0; // no 1s
        return (maxR - minR + 1) * (maxC - minC + 1);
    }
}
