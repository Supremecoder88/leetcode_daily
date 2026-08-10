class Solution {
    public int findKthPositive(int[] arr, int k) {

        int current = 1;

        for (int num : arr) {

            while (current < num) {
                k--;

                if (k == 0) {
                    return current;
                }

                current++;
            }

            current = num + 1;
        }

        // Missing numbers after the end of array
        return current + k - 1;
    }
}