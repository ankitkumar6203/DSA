class Solution {
    public void reverseString(char[] s) {
        int n = s.length;
        for (int i = 0; i < n / 2; i++) {
            int j = n - 1 - i;
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }

        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i] + ",");
        }
    }
}
