import java.util.*;

class Solution {
    public String reorganizeString(String s) {

        // Count frequency of each character
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Max heap: highest frequency first
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> b[1] - a[1]
        );

        // Put all characters into heap
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.offer(new int[]{i, freq[i]});
            }
        }

        StringBuilder result = new StringBuilder();

        int[] previous = null;

        while (!pq.isEmpty()) {

            int[] current = pq.poll();

            // Use current character
            result.append((char) (current[0] + 'a'));
            current[1]--;

            // Put previous character back
            if (previous != null && previous[1] > 0) {
                pq.offer(previous);
            }

            // Current becomes previous
            previous = current;
        }

        // If we couldn't use all characters, impossible
        if (result.length() != s.length()) {
            return "";
        }

        return result.toString();
    }
}