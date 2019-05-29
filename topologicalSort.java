import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
class topologicalSort {
    private ArrayList<Integer>[] map;
    private int[] ret;
    private int[] index;
    private int count = 0;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ret=new int[numCourses];
        index=new int[numCourses];
        map =new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            map[i]=new ArrayList<Integer>();
        }
        for(int[] num:prerequisites){
            map[num[1]].add(num[0]);
            index[num[0]]++;}
        pop();
        int[] kong = {};
        return count == numCourses ? ret : kong;
    }
    void pop(){
        Queue<Integer> queue= new LinkedList<Integer>();
        for(int i=0;i<index.length;i++){
            if(index[i]==0){
                queue.offer(i);
            }}
        int ind=-1;
        while(!queue.isEmpty()){
            int cur=queue.poll();
            count++;
            ret[++ind]=cur;
            for(int i=0;i<map[cur].size();i++){
                int e = map[cur].get(i);
                if(--index[e]==0){
                    queue.offer(map[cur].get(i));
                }}
            map[cur].clear();
        }
    }
}