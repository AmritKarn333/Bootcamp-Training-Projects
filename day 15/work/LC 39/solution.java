class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] candidates, int target, int start,
                           List<Integer> curr, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        if (target < 0) return;

        for (int i = start; i < candidates.length; i++) {
            curr.add(candidates[i]);

            // i, not i + 1, because the same number can be reused
            backtrack(candidates, target - candidates[i], i, curr, res);

            curr.remove(curr.size() - 1);
        }
    }
}