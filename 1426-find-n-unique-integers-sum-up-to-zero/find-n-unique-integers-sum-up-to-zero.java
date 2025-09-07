class Solution {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        int start=0;
        int end=n-1;
        int temp=n/2;
        while(start<=end){
            ans[start] = -temp;
            ans[end] = temp;
            temp--;
            start++;
            end--;
        }
        return ans;
    }
}