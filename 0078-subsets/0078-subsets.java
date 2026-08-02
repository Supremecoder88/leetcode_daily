class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {

        backtrack(0, nums, new ArrayList<>());

        return ans;
    }

    private void backtrack(int index, int[] nums, List<Integer> current) {

        // All elements considered
        if (index == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }

        // Take
        current.add(nums[index]);
        backtrack(index + 1, nums, current);

        // Backtrack
        current.remove(current.size() - 1);

        // Don't Take
        backtrack(index + 1, nums, current);
    }
}