class Solution {
    public List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        
        solve(arr, list, ans);
        return ans;
    }

    public void solve(int[] arr, List<Integer> list, List<List<Integer>> ans) {
        if (list.size() == arr.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (list.contains(arr[i])) {
                continue;
            }

            list.add(arr[i]);      
            solve(arr, list, ans);  
            list.remove(list.size() - 1); 
        }
    }
}