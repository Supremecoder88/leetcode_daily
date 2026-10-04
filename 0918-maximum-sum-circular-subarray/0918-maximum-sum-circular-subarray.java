class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        int total = 0;

        int currentMax = 0;
        int maxSum = nums[0];

        int currentMin = 0;
        int minSum = nums[0];

        for (int num : nums) {

            // Kadane for maximum subarray
            currentMax = Math.max(num, currentMax + num);
            maxSum = Math.max(maxSum, currentMax);

            // Kadane for minimum subarray
            currentMin = Math.min(num, currentMin + num);
            minSum = Math.min(minSum, currentMin);

            total += num;
        }

        // All numbers are negative
        if (maxSum < 0) {
            return maxSum;
        }

        // Normal max OR circular max
        return Math.max(maxSum, total - minSum);
    }
}