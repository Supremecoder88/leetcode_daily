class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int low = 0;
        int high = 0;

        for (int weight : weights) {
            low = Math.max(low, weight);
            high += weight;
        }

        while (low < high) {

            int mid = low + (high - low) / 2;

            int daysNeeded = 1;
            int currentLoad = 0;

            for (int weight : weights) {

                if (currentLoad + weight > mid) {
                    daysNeeded++;
                    currentLoad = weight;
                } else {
                    currentLoad += weight;
                }
            }

            if (daysNeeded <= days) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}