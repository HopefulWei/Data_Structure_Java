class removeStones {
    int[] parent = null;
    int size = 0;
    //判断联通
    final Integer[] record = new Integer[20000];
    public int removeStones(final int[][] stones) {
        //初始化数组
        parent = new int[stones.length];
        for (int i = 0; i < stones.length; i++) {
            parent[i] = i;
            int[] stone = stones[i];
            Integer xInt = record[stone[0]];
            Integer yInt = record[stone[1] + 10000];
            if (xInt == null && yInt == null) {
                record[stone[0]] = i;
                record[stone[1] + 10000] = i;
                size++;
            } else if (xInt == null) {
                record[stone[0]] = i;
                union(yInt, i, false);
            } else if (yInt == null) {
                record[stone[1] + 10000] = i;
                union(xInt, i, false);
            } else {
                union(xInt, yInt, true);
            }
        }
        return stones.length - size;
    }

    private void union(int a, int b, boolean flag) {
        int ap = parent[a];
        int bp = parent[b];
        if (ap == bp) return;
        else if (ap != a || bp != b) union(ap, bp, flag);
        else {
            parent[b] = a;
            if (flag) {
                size--;
            }
        }
    }
}