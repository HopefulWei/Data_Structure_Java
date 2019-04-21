import java.util.Stack;
class MyQueue{
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    /** Initialize your data structure here. */
    public MyQueue() {
        stackPush = new Stack<Integer>();
        stackPop = new Stack<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stackPush.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stackPop.isEmpty()){
            while(!stackPush.empty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(stackPop.isEmpty()){
            while(!stackPush.empty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stackPush.isEmpty() && stackPop.isEmpty();
    }

    public static void main(String[] args){
        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.peek()); // 返回 1queue.empty(
        queue.pop();   // 返回 1
        System.out.println(queue.pop());
        queue.push(9);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.empty()); // 返回 false
}

}