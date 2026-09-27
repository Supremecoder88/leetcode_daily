class Solution {
    public String longestDiverseString(int a, int b, int c) {

        StringBuilder ans = new StringBuilder();

        while (a > 0 || b > 0 || c > 0) {

            // Find the character with largest count
            int max = Math.max(a, Math.max(b, c));

            char ch;

            if (max == a) {
                ch = 'a';
            } else if (max == b) {
                ch = 'b';
            } else {
                ch = 'c';
            }

            // Check whether we can use this character
            if (ans.length() >= 2 &&
                ans.charAt(ans.length() - 1) == ch &&
                ans.charAt(ans.length() - 2) == ch) {

                // Need to choose another character
                if (ch == 'a') {
                    if (b == 0 && c == 0) break;

                    if (b >= c) {
                        ans.append('b');
                        b--;
                    } else {
                        ans.append('c');
                        c--;
                    }

                } else if (ch == 'b') {
                    if (a == 0 && c == 0) break;

                    if (a >= c) {
                        ans.append('a');
                        a--;
                    } else {
                        ans.append('c');
                        c--;
                    }

                } else {
                    if (a == 0 && b == 0) break;

                    if (a >= b) {
                        ans.append('a');
                        a--;
                    } else {
                        ans.append('b');
                        b--;
                    }
                }

            } else {

                // We can add the most frequent character
                if (ch == 'a') {
                    ans.append('a');
                    a--;
                } else if (ch == 'b') {
                    ans.append('b');
                    b--;
                } else {
                    ans.append('c');
                    c--;
                }
            }
        }

        return ans.toString();
    }
}