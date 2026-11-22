class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);

        int c = cuts.length;
        int[] arr = new int[c + 2];

        arr[0] = 0;
        arr[c + 1] = n;

        for (int i = 0; i < c; i++) {
            arr[i + 1] = cuts[i];
        }

        int[][] dp = new int[c + 2][c + 2];

        for (int len = 1; len <= c; len++) {
            for (int i = 1; i + len - 1 <= c; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k <= j; k++) {
                    int cost = arr[j + 1] - arr[i - 1]
                             + dp[i][k - 1]
                             + dp[k + 1][j];

                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[1][c];
    }
}