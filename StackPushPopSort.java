import java.util.Stack;
class Solution {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> record = new Stack<>();
        int i = 0;
        int j = 0;
        while (i < popped.length) {
            if ((record.size() == 0 && j < pushed.length) || (record.peek() != popped[i] && j < pushed.length)) {
                record.push(pushed[j]);
                j = j + 1;
                continue;
            }
            if (record.peek() == popped[i]) {
                record.pop();
                i = i + 1;
                continue;
            }
            return false;
        }
        return true;
    }
    public static void main(String[] args){
        int[] A ={1,2,3};
        int[] B ={3,2,1};
        boolean S = validateStackSequences(A,B);
        System.out.println(S);
    }
}
