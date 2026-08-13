class Solution {
    public int[] findPeakGrid(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        int left = 0;
        int right = n - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            // Find maximum element in column mid
            int row = 0;

            for (int i = 1; i < m; i++) {
                if (mat[i][mid] > mat[row][mid]) {
                    row = i;
                }
            }

            int current = mat[row][mid];

            // Left and right neighbors
            int leftValue = (mid > 0) ? mat[row][mid - 1] : -1;
            int rightValue = (mid < n - 1) ? mat[row][mid + 1] : -1;

            // Current is a peak
            if (current > leftValue && current > rightValue) {
                return new int[]{row, mid};
            }

            // Bigger element on right
            if (rightValue > current) {
                left = mid + 1;
            }

            // Bigger element on left
            else {
                right = mid - 1;
            }
        }

        return new int[]{-1, -1};
    }
}