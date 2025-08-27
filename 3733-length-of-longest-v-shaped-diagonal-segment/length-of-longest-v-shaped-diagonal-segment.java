class Solution {
  public int lenOfVDiagonal(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    Integer[][][][][] mem = new Integer[m][n][2][2][4];
    int ans = 0;

    int[][] dirs = {{-1,1}, {1,1}, {1,-1}, {-1,-1}};

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          for (int d = 0; d < 4; d++) {
            int dx = dirs[d][0], dy = dirs[d][1];
            ans = Math.max(ans, 1 + dfs(grid, i + dx, j + dy, false, 2, d, mem, dirs));
          }
        }
      }
    }

    return ans;
  }

  private int dfs(int[][] grid, int i, int j, boolean turned, int num, int dir,
                  Integer[][][][][] mem, int[][] dirs) {
    int m = grid.length, n = grid[0].length;
    if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != num) {
      return 0;
    }
    int turnedIdx = turned ? 1 : 0;
    int hashNum = Math.max(0, num - 1);
    if (mem[i][j][turnedIdx][hashNum][dir] != null) {
      return mem[i][j][turnedIdx][hashNum][dir];
    }

    int nextNum = (num == 2) ? 0 : 2;
    int dx = dirs[dir][0], dy = dirs[dir][1];
    int res = 1 + dfs(grid, i + dx, j + dy, turned, nextNum, dir, mem, dirs);

    if (!turned) {
      int nextDir = (dir + 1) % 4; // clockwise turn
      int ndx = dirs[nextDir][0], ndy = dirs[nextDir][1];
      res = Math.max(res,
                     1 + dfs(grid, i + ndx, j + ndy, true, nextNum, nextDir, mem, dirs));
    }

    return mem[i][j][turnedIdx][hashNum][dir] = res;
  }
}
