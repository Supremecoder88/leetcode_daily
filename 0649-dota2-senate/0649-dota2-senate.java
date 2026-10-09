import java.util.*;

class Solution {
    public String predictPartyVictory(String senate) {

        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();

        int n = senate.length();

        // Store positions of each party
        for (int i = 0; i < n; i++) {

            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }

        // Continue until one party has no senators
        while (!radiant.isEmpty() && !dire.isEmpty()) {

            int r = radiant.poll();
            int d = dire.poll();

            if (r < d) {

                // Radiant acts first and bans Dire
                radiant.offer(r + n);

            } else {

                // Dire acts first and bans Radiant
                dire.offer(d + n);
            }
        }

        if (!radiant.isEmpty()) {
            return "Radiant";
        }

        return "Dire";
    }
}