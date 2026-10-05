import java.util.*;

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        // Total cards must be divisible by groupSize
        if (hand.length % groupSize != 0) {
            return false;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();

        // Count frequency of every card
        for (int card : hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        while (!map.isEmpty()) {

            // Smallest available card
            int first = map.firstKey();

            // Try to make:
            // first, first+1, first+2, ...
            for (int i = 0; i < groupSize; i++) {

                int card = first + i;

                // Required consecutive card doesn't exist
                if (!map.containsKey(card)) {
                    return false;
                }

                // Use one copy of this card
                map.put(card, map.get(card) - 1);

                // Remove card if no copies remain
                if (map.get(card) == 0) {
                    map.remove(card);
                }
            }
        }

        return true;
    }
}