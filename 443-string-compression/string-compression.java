class Solution {
    public int compress(char[] chars) {
        int index = 0;  
        int i = 0;     

        while (i < chars.length) {
            char currentChar = chars[i];
            int count = 0;

            while (i < chars.length && chars[i] == currentChar) {
                i++;
                count++;
            }

            chars[index++] = currentChar;

            if (count > 1) {
                String cntStr = String.valueOf(count);
                for (char c : cntStr.toCharArray()) {
                    chars[index++] = c;
                }
            }
        }

        return index; // length of compressed array
    }
}
