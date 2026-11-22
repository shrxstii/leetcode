class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int num : nums) {
            int low = 0;
            int high = list.size();

            while (low < high) {
                int mid = low + (high - low) / 2;

                if (list.get(mid) < num) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }

            if (low == list.size()) {
                list.add(num);
            } else {
                list.set(low, num);
            }
        }

        return list.size();
    }
}