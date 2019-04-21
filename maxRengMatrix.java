
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int mianjiMax=0;
        if(matrix.length==0||matrix[0].length==0){return 0;}
        int[][] matrixInt=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix[0].length;i++){
            matrixInt[0][i] = matrix[0][i] - 48;
        }
        for(int i=1;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='0'){matrixInt[i][j]=0;}
                else{matrixInt[i][j]=matrixInt[i-1][j]+1;}
            }}
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if (matrixInt[i][j] > 0) {
                    int left=j-1;
                    int right=j+1;
                    int wide=1;
                    while(left>=0 && matrixInt[i][left]>=matrixInt[i][j]){
                        left=left-1;
                        wide=wide+1;
                    }
                    while(right<matrixInt[0].length && matrixInt[i][right]>=matrixInt[i][j]){
                        right=right+1;
                        wide=wide+1;
                    }
                    int mianji=wide*(matrixInt[i][j]);
                    if(mianji>mianjiMax){mianjiMax=mianji;}
                }}}
        return mianjiMax;
    }}