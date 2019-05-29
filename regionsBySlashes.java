class regionsBySlashes {
    public int regionsBySlashes(String[] grid) {
        int[][] map=new int[grid.length*3][grid.length*3];
        for (int i=0;i<grid.length;i++)
        {
            for (int j=0;j<grid.length;j++)
            {
                if(grid[i].charAt(j)=='/')
                {
                    map[i*3][j*3+2]=map[i*3+1][j*3+1]=map[i*3+2][j*3]=1;
                }
                else if(grid[i].charAt(j)=='\\')
                {
                    map[i*3][j*3]=map[i*3+1][j*3+1]=map[i*3+2][j*3+2]=1;
                }
            }
        }

        int res=0;
        for (int i=0;i<map.length;i++)
        {
            for (int j=0;j<map[0].length;j++)
            {
                if(map[i][j]==0)
                {
                    dfs(map,i,j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(int[][] map, int i, int j) {
        if(i>=0&&i<map.length&&j>=0&&j<map[0].length&&map[i][j]==0)
        {
            map[i][j]=1;
            dfs(map,i-1,j);
            dfs(map,i,j-1);
            dfs(map,i,j+1);
            dfs(map,i+1,j);
        }
    }
}