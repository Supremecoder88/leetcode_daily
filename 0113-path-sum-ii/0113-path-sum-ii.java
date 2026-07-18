/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        dfs(root, targetSum, new ArrayList<>());

        return ans;
    }

    void dfs(TreeNode node, int target, List<Integer> path) {

        if (node == null)
            return;

        // Choose
        path.add(node.val);

        target -= node.val;

        // Leaf node
        if (node.left == null && node.right == null) {

            if (target == 0) {
                ans.add(new ArrayList<>(path)); // Copy the path
            }

        } else {

            dfs(node.left, target, path);
            dfs(node.right, target, path);
        }

        // Backtrack
        path.remove(path.size() - 1);
    }
}