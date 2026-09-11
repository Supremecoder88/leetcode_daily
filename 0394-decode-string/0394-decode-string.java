import java.util.*;

class Solution {
    public String decodeString(String s) {
        
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        
        StringBuilder current = new StringBuilder();
        int num = 0;
        
        for (char c : s.toCharArray()) {
            
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            
            else if (c == '[') {
                countStack.push(num);
                stringStack.push(current.toString());
                
                num = 0;
                current = new StringBuilder();
            }
            
            else if (c == ']') {
                int count = countStack.pop();
                String previous = stringStack.pop();
                
                StringBuilder temp = new StringBuilder(previous);
                
                for (int i = 0; i < count; i++) {
                    temp.append(current);
                }
                
                current = temp;
            }
            
            else {
                current.append(c);
            }
        }
        
        return current.toString();
    }
}