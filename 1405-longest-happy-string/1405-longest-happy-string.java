import java.util.*;

class Solution {
    public String longestDiverseString(int a, int b, int c) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (x, y) -> y[1] - x[1]
        );

        if (a > 0) pq.offer(new int[]{0, a});
        if (b > 0) pq.offer(new int[]{1, b});
        if (c > 0) pq.offer(new int[]{2, c});

        StringBuilder result = new StringBuilder();

        while (!pq.isEmpty()) {

            int[] first = pq.poll();

            // If using first would create 3 same characters
            if (result.length() >= 2 &&
                result.charAt(result.length() - 1) == (char) ('a' + first[0]) &&
                result.charAt(result.length() - 2) == (char) ('a' + first[0])) {

                // No second character available
                if (pq.isEmpty()) {
                    break;
                }

                // Use the second most frequent character
                int[] second = pq.poll();

                result.append((char) ('a' + second[0]));
                second[1]--;

                if (second[1] > 0) {
                    pq.offer(second);
                }

                // Put first character back
                pq.offer(first);

            } else {

                // We can use up to 2 copies
                int use = Math.min(2, first[1]);

                for (int i = 0; i < use; i++) {
                    result.append((char) ('a' + first[0]));
                }

                first[1] -= use;

                if (first[1] > 0) {
                    pq.offer(first);
                }
            }
        }

        return result.toString();
    }
}