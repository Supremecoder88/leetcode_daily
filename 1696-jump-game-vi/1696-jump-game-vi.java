class Solution {

    public int maxResult(int[] nums, int k) {

        int n = nums.length;

        int[] dp = new int[n];

        dp[0] = nums[0];

        Deque<Integer> dq = new ArrayDeque<>();

        dq.offer(0);

        for(int i = 1; i < n; i++) {

            // Remove indices outside the window
            while(!dq.isEmpty() && dq.peekFirst() < i - k) {
                dq.pollFirst();
            }

            // Best previous score
            dp[i] = dp[dq.peekFirst()] + nums[i];

            // Maintain decreasing dp values
            while(!dq.isEmpty() &&
                  dp[dq.peekLast()] <= dp[i]) {

                dq.pollLast();
            }

            dq.offerLast(i);
        }

        return dp[n-1];
    }
}