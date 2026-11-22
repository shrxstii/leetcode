class Solution {
    public int longestPalindrome(String s) {
        int[] freq = new int[128];

        for (char ch : s.toCharArray()) {
            freq[ch]++;
        }

        int count = 0;
        boolean odd = false;

        for (int f : freq) {
            count += (f / 2) * 2;

            if (f % 2 == 1) {
                odd = true;
            }
        }

        return odd ? count + 1 : count;
    }
}