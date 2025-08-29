class Solution {
    public long flowerGame(int n, int m) {
        long neven=n/2;
        long modd=(m%2==0)?m/2:(m/2)+1;

        long meven = m/2;
        long nodd = (n%2==0)?n/2:(n/2)+1;

        long ans = neven*modd+meven*nodd;

        return ans;
    }
}