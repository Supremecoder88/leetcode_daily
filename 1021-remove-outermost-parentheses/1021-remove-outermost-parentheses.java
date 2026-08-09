class Solution {

    public String removeOuterParentheses(String s) {

        int l = s.length();

        int outer = 0;

        StringBuilder ans = new StringBuilder();

        // Simulates the outermost opening parenthesis
        int stack = 0;

        for (char ch : s.toCharArray()) {

            // First opening parenthesis of a primitive
            if (stack == 0 && ch == '(') {
                stack = 1;
            }

            // Inner opening parentheses
            else if (ch == '(' && outer >= 0) {
                outer++;
                ans.append(ch);
            }

            // Inner closing parentheses
            else if (ch == ')' && outer != 0) {
                outer--;
                ans.append(ch);
            }

            // Last closing parenthesis of a primitive
            else if (stack == 1 && ch == ')' && outer == 0) {
                stack = 0;
            }
        }

        return ans.toString();
    }
}