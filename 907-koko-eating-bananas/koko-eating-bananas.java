class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 0;

        for(int x : piles)
            r = Math.max(r, x);

        while(l < r) {
            int k = l + (r - l) / 2;
            int hours = 0;

            for(int x : piles)
                hours += (x + k - 1) / k;

            if(hours <= h)
                r = k;
            else
                l = k + 1;
        }

        return l;
    }
}