
import java.util.*;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        int limit = nums.length / 3;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : map.keySet()) {
            if (map.get(num) > limit) {
                result.add(num);
            }
        }

        return result;
    }
}
