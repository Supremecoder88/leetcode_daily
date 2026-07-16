class Solution {

    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> partition(String s) {

        backtrack(s, 0, new ArrayList<>());

        return ans;
    }

    void backtrack(String s,
                   int start,
                   List<String> curr){

        if(start == s.length()){

            ans.add(new ArrayList<>(curr));

            return;
        }

        for(int end = start; end < s.length(); end++){

            if(isPalindrome(s, start, end)){

                curr.add(s.substring(start, end+1));

                backtrack(s, end+1, curr);

                curr.remove(curr.size()-1);
            }
        }
    }

    boolean isPalindrome(String s,
                         int l,
                         int r){

        while(l < r){

            if(s.charAt(l)!=s.charAt(r))
                return false;

            l++;
            r--;
        }

        return true;
    }
}