class Solution {

    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) {
            return false;
        }

        int[] charC= new int[26];

        for(int i=0;i<s.length();i++){
            charC[s.charAt(i)-'a']++;
            charC[t.charAt(i)-'a']--;
        }
        for(int count : charC){
            if(count !=0){
                return false;
            }
        }
        return true;
    }
}