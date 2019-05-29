import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Collections;
class skyLine {
    public class Nod {
        public int x;
        public boolean start;
        public Integer h;

        public Nod(int x, boolean start, Integer h) {
            this.x = x;
            this.start = start;
            this.h = h;
        }
    }

    public List<int[]> getSkyline(int[][] buildings) {
        List<Nod> nods = new ArrayList<Nod>();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a1, a2)->a2 - a1);
        List<int[]> result = new ArrayList<int[]>();

        for (int i=0; i<buildings.length; i++) {
            int[] b = buildings[i];
            Integer y = new Integer(b[2]);
            nods.add(new Nod(b[0], true, y));
            nods.add(new Nod(b[1], false, y));
        }
        Collections.sort(nods, (a1, a2)->a1.x - a2.x);

        int j = 0;
        int prevHeight = 0;
        while (j < nods.size()) {
            int cx = nods.get(j).x; //current x
            while (j<nods.size() && nods.get(j).x == cx){
                Nod nd = nods.get(j);
                if (nd.start) {
                    pq.add(nd.h);
                } else {
                    pq.remove(nd.h);
                }
                j++;
            }
            Integer ch = pq.peek(); // current max height
            if (ch==null) {
                ch = 0;
            }
            if (ch != prevHeight) {
                prevHeight = ch;
                result.add(new int[] {cx, ch});
            }
        }
        return result;
    }
}