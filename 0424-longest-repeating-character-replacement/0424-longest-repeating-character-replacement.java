class Solution {
    public int characterReplacement(String s, int k) {

        int[] freq = new int[26];

        int left = 0;
        int maxFreq = 0;
        int ans = 0;

        for (int right = 0; right < s.length(); right++) {

            int index = s.charAt(right) - 'A';

            freq[index]++;

            maxFreq = Math.max(maxFreq, freq[index]);

            int windowLength = right - left + 1;

            // Number of replacements needed
            int replacements = windowLength - maxFreq;

            while (replacements > k) {

                freq[s.charAt(left) - 'A']--;

                left++;

                windowLength = right - left + 1;
                replacements = windowLength - maxFreq;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}