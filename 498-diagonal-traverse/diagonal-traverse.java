class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) return new int[0];

        int m = mat.length;      // number of rows
        int n = mat[0].length;   // number of cols
        int[] result = new int[m * n];
        int index = 0;

        for (int d = 0; d < m + n - 1; d++) {
            
            List<Integer> diagonal = new ArrayList<>();

            int row = d < n ? 0 : d - n + 1;
            int col = d < n ? d : n - 1;

            while (row < m && col >= 0) {
                diagonal.add(mat[row][col]);
                row++;
                col--;
            }

            if (d % 2 == 0) {
                Collections.reverse(diagonal);
            }

            for (int num : diagonal) {
                result[index++] = num;
            }
        }

        return result;
    }
}
