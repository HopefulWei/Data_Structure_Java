import java.util.HashSet;
class networkDelay{
        private final  int inf=1000000;
        private int findMin(int[] distance,HashSet<Integer> visited){
                int index=0;
                int val=distance[0];
                for(int i=1;i<distance.length;i++) {
                        if (!visited.contains(i) && distance[i] < val) {
                                val = distance[i];
                                index = i;
                        }
                }
                return index;
        }
        public int networkDelayTime(int[][] times, int N, int K) {
                int[] distance=new int[N+1];
                for(int i=0;i<=N;i++)
                        distance[i]=inf;
                distance[K]=0;
                HashSet<Integer> visited=new HashSet<>();
                int[][]g=new int[N+1][N+1];

                for(int i=0;i<=N;i++)
                        for(int j=0;j<=N;j++)
                                g[i][j]=i==j?0:distance[0];
                for(int[] e:times)
                        g[e[0]][e[1]]=e[2];

                while (true){
                        int u=findMin(distance,visited);
                        //System.out.println("find:"+u);

                        if(distance[u]==distance[0])
                                break;
                        visited.add(u);
                        for(int v=1;v<=N;v++ ){
                                if(distance[v]>distance[u]+g[u][v]){
                                        distance[v]=distance[u]+g[u][v];

                                }
                        }
                }
                if(N==visited.size()){
                        int d=0;
                        for(int i=1;i<distance.length;i++)
                                if(distance[i]>d)
                                        d=distance[i];
                        return d;

                }
                return -1;
        }
}

