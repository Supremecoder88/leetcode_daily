import java.util.*;

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        int oddCount = 0;
        int count = 0;

        for (int num : nums) {
            if (num % 2 != 0) {
                oddCount++;
            }

            int needed = oddCount - k;

            count += map.getOrDefault(needed, 0);

            map.put(oddCount, map.getOrDefault(oddCount, 0) + 1);
        }

        return count;
    }
}