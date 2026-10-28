class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] left = new int[n], right = new int[n];
        java.util.Arrays.fill(left, -1);
        java.util.Arrays.fill(right, n);
        java.util.Deque<Integer> stk = new java.util.ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            while (!stk.isEmpty() && arr[stk.peek()] >= arr[i]) stk.pop();
            if (!stk.isEmpty()) left[i] = stk.peek();
            stk.push(i);
        }
        stk.clear();
        for (int i = n - 1; i >= 0; --i) {
            while (!stk.isEmpty() && arr[stk.peek()] > arr[i]) stk.pop();
            if (!stk.isEmpty()) right[i] = stk.peek();
            stk.push(i);
        }
        long ans = 0, mod = (long) 1e9 + 7;
        for (int i = 0; i < n; ++i) {
            ans = (ans + (long) (i - left[i]) * (right[i] - i) % mod * arr[i]) % mod;
        }
        return (int) ans;
    }
}
