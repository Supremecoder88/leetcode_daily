class Solution {
    public int maxDepth(String s) {
        int maxCount = 0;
        int n = s.length();
        int count = 0;
        for(int i = 0;i < n;i++){
            
            if(s.charAt(i) == ')') count--;
            if(s.charAt(i) == '(') count++;
            

            maxCount = Math.max(count,maxCount);
        }

        return maxCount;
    }
}