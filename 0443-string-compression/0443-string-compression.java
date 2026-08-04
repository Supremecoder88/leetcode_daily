class Solution {
    public int compress(char[] chars) {

        int write = 0;
        int i = 0;

        while (i < chars.length) {

            char current = chars[i];
            int count = 0;

            // Count consecutive characters
            while (i < chars.length && chars[i] == current) {
                i++;
                count++;
            }

            // Write character
            chars[write++] = current;

            // Write count if greater than 1
            if (count > 1) {

                String str = String.valueOf(count);

                for (char c : str.toCharArray()) {
                    chars[write++] = c;
                }
            }
        }

        return write;
    }
}