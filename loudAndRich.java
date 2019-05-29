class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        List<Integer>[] map=new List[quiet.length];
        for (int i=0;i<quiet.length;i++)map[i]=new ArrayList<>();
        for (int[] r:richer)
        {
            map[r[1]].add(r[0]);
        }
        int[] res=new int[quiet.length];
        Arrays.fill(res,-1);
        for (int i=0;i<quiet.length;i++)
        {
            dfs(i,map,res,quiet);
        }
        return res;

    }

    private int dfs(int i, List<Integer>[] map, int[] res,int[] quiet) {
        if(res[i]>=0)return res[i];
        res[i]=i;
        for (int j:map[i])
        {
            if(quiet[res[i]]>quiet[dfs(j,map,res,quiet)])
            {
                res[i]=res[j];
            }
        }
        return res[i];
    }
}