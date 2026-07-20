class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        int i = 0;
        int j = 0;
        int star = -1;
        int match = -1;
        while(i<m){
            if(j<n && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='?')){
                i++;
                j++;
                continue;
            }
            if(j<n && p.charAt(j)=='*'){
                star = j;
                match = i;
                j++;
                continue;
            }
            if(star==-1) return false;
            j = star+1;
            match++;
            i = match;
        }

        while(j<n){
            if(p.charAt(j)!='*') return false;
            j++;
        }
        
        return true;
    }
}