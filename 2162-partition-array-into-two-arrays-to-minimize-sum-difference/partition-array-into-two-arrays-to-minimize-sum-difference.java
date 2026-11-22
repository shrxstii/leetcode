class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length / 2;
        int total = 0;

        for (int x : nums) {
            total += x;
        }

        List<Integer>[] left = new ArrayList[n + 1];
        List<Integer>[] right = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            left[i] = new ArrayList<>();
            right[i] = new ArrayList<>();
        }

        generate(nums, 0, n, left);
        generate(nums, n, nums.length, right);

        for (List<Integer> list : right) {
            Collections.sort(list);
        }

        int ans = Integer.MAX_VALUE;

        for (int k = 0; k <= n; k++) {
            List<Integer> a = left[k];
            List<Integer> b = right[n - k];

            for (int x : a) {
                int target = (total - 2 * x) / 2;

                int low = 0;
                int high = b.size() - 1;

                while (low <= high) {
                    int mid = low + (high - low) / 2;

                    int sum = x + b.get(mid);
                    ans = Math.min(ans, Math.abs(total - 2 * sum));

                    if (sum * 2 < total) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }

                if (low < b.size()) {
                    int sum = x + b.get(low);
                    ans = Math.min(ans, Math.abs(total - 2 * sum));
                }
            }
        }

        return ans;
    }

    void generate(int[] nums, int start, int end, List<Integer>[] result) {
        int len = end - start;

        for (int mask = 0; mask < (1 << len); mask++) {
            int sum = 0;
            int count = 0;

            for (int i = 0; i < len; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += nums[start + i];
                    count++;
                }
            }

            result[count].add(sum);
        }
    }
}