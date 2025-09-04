class Solution {
    public int findClosest(int x, int y, int z) {
        int diffZX = Math.abs(z-x);
        int diffZY = Math.abs(z-y);

        if(diffZX < diffZY){
            return 1;
        }
        else if(diffZX == diffZY){
            return 0;
        }else{
            return 2;
        }
    }
}