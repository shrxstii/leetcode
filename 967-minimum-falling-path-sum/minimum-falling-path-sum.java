class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[] dp = matrix[0].clone();

        for (int i = 1; i < n; i++) {
            int[] curr = new int[n];

            for (int j = 0; j < n; j++) {
                int up = dp[j];
                int left = j > 0 ? dp[j - 1] : Integer.MAX_VALUE;
                int right = j < n - 1 ? dp[j + 1] : Integer.MAX_VALUE;

                curr[j] = matrix[i][j] + Math.min(up, Math.min(left, right));
            }

            dp = curr;
        }

        int ans = Integer.MAX_VALUE;

        for (int x : dp) {
            ans = Math.min(ans, x);
        }

        return ans;
    }
}