class Solution {

    public boolean isAlienSorted(String[] words, String order) {

        int[] rank = new int[26];

        // Store the position of each character
        for (int i = 0; i < 26; i++) {
            rank[order.charAt(i) - 'a'] = i;
        }

        // Compare adjacent words
        for (int i = 0; i < words.length - 1; i++) {

            if (!isValid(words[i], words[i + 1], rank)) {
                return false;
            }
        }

        return true;
    }

    private boolean isValid(String word1, String word2, int[] rank) {

        int minLength = Math.min(word1.length(), word2.length());

        for (int i = 0; i < minLength; i++) {

            char c1 = word1.charAt(i);
            char c2 = word2.charAt(i);

            // Characters are equal, continue
            if (c1 == c2) {
                continue;
            }

            // Compare alien alphabet positions
            return rank[c1 - 'a'] < rank[c2 - 'a'];
        }

        // All common characters were equal.
        // Shorter word must come first.
        return word1.length() <= word2.length();
    }
}