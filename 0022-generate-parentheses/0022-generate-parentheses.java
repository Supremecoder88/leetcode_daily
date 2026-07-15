class Solution {

    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {

        backtrack("", 0, 0, n);

        return ans;
    }

    private void backtrack(String curr,
                           int open,
                           int close,
                           int n) {

        if(curr.length() == 2 * n) {

            ans.add(curr);
            return;
        }

        if(open < n) {

            backtrack(curr + "(",
                      open + 1,
                      close,
                      n);
        }

        if(close < open) {

            backtrack(curr + ")",
                      open,
                      close + 1,
                      n);
        }
    }
}