class Solution {
    public int characterReplacement(String s, int k) {

        int left = 0;
        int ans = 0;

        int[] occ = new int[26];
        int maxO = 0;

        for (int right = 0; right < s.length(); right++) {

            maxO = Math.max(maxO, ++occ[s.charAt(right) - 'A']);

            while ((right - left + 1) - maxO > k) {

                occ[s.charAt(left) - 'A']--;
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}