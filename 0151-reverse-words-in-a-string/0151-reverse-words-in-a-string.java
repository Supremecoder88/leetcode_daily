class Solution {
    public String reverseWords(String s) {

        // Remove leading/trailing spaces and split by one or more spaces
        String[] words = s.trim().split("\\s+");

        StringBuilder sb = new StringBuilder();

        // Traverse from the last word to the first
        for (int i = words.length - 1; i >= 0; i--) {

            sb.append(words[i]);

            // Add space between words (not after the last one)
            if (i != 0) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}