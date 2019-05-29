import java.util.Queue;
import java.util.PriorityQueue;
class MedianFinder {
    private Queue<Integer> queueMin;
    private Queue<Integer> queueMax;
    /** initialize your data structure here. */
    public MedianFinder() {
        queueMin =  new PriorityQueue<Integer>((a1,a2)->a1-a2);
        queueMax =  new PriorityQueue<Integer>((a2,a1)->a2-a1);
    }

    public void addNum(int num) {
        if(queueMin.isEmpty()&&queueMax.isEmpty()) {
            queueMin.add(num);
        }else if(queueMax.isEmpty()) {
            if(num<=queueMin.peek()){
                queueMax.add(num);
            }else{
                int mid=queueMin.poll();
                queueMin.add(num);
                queueMax.add(mid);
            }}else{
            if(queueMax.size()==queueMin.size()){
                if(num<=queueMax.peek()){queueMax.add(num);}
                else{queueMin.add(num);}
            }else if(queueMax.size()<queueMin.size()){
                if(num<=queueMin.peek()){queueMax.add(num);}
                else{
                    queueMin.add(num);
                    int mid =queueMin.poll();
                    queueMax.add(mid);
                }}else{
                if(num>=queueMax.peek()){queueMin.add(num);}
                else{
                    queueMax.add(num);
                    int mid = queueMax.poll();
                    queueMin.add(mid);
                }}
        }

    }

    public double findMedian() {
        if((queueMax.size()+queueMin.size())%2==0){
            double m = queueMax.peek()+queueMin.peek();
            return m/2;
        }else if(queueMax.size()>queueMin.size()){
            double m = queueMax.peek();
            return m;
        }else{
            double m = queueMin.peek();
            return m;
        }
    }
}