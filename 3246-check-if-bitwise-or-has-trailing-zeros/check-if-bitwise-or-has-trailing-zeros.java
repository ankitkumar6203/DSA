class Solution {
    public boolean hasTrailingZeros(int[] nums) {
        int evenCount=0;
        for(int x:nums){
            if(x%2==0){
                evenCount++;
                if(evenCount >= 2){
                    return true;
                }
            }

        }
        return false;
    }
}