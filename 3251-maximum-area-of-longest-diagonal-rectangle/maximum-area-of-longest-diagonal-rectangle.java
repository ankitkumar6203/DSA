class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxArea = 0;
        int maxDiag=0;
        
        for(int i=0;i<dimensions.length;i++){
            int l = dimensions[i][0];
            int w = dimensions[i][1];
            int area = l*w;
            int diag = l*l+w*w;
            if(diag>maxDiag){
                maxDiag=diag;
                maxArea=area;
            }
            if(diag==maxDiag){
                maxArea=Math.max(maxArea,area);
            }
        }
        return maxArea;
    }
}