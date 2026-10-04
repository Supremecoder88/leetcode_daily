class Solution {
    public int maxTurbulenceSize(int[] arr) {

        int left = 0;
        int ans = 1;

        for (int right = 1; right < arr.length; right++) {

            // Equal values -> start again
            if (arr[right] == arr[right - 1]) {
                left = right;
            }

            // Check whether the comparison sign is alternating
            else if (right == 1 ||
                     (arr[right] > arr[right - 1] &&
                      arr[right - 1] <= arr[right - 2]) ||
                     (arr[right] < arr[right - 1] &&
                      arr[right - 1] >= arr[right - 2])) {

                // Continue the turbulent subarray
            }

            else {
                // Pattern broke, start from previous element
                left = right - 1;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}