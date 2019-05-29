import java.util.ArrayList;
import java.util.List;
class FibonacciSequence {
    public List<Integer> splitIntoFibonacci(String S) {
        /**
         使用一个辅助List保存可行的序列, 在回溯过程中发现返回List不为空
         说明有一种满足的序列产生提前终止回溯
         **/
        List<Integer> ret = new ArrayList<>();
        bktrace(S, ret, new ArrayList<>(), 0);
        return ret;
    }

    private void bktrace(String s, List<Integer> ret, List<Integer> temp, int st) {
        // 提前终止回溯
        if(ret.size() != 0) return;
        if(st == s.length() && temp.size() >= 3) {
            ret.addAll(temp);
            return;
        }
        for(int i = st; i < s.length(); ++i) {
            // 每块数组除非为0否则不能以0开头
            if(s.charAt(st) == '0' && i > st)
                break;
            // 每块数字不超过2^31-1
            long num = Long.parseLong(s.substring(st, i+1));
            if(num > Integer.MAX_VALUE)
                break;

            int size = temp.size();
            // 提前终止回溯的条件, 注意是大于, 因为如果是小于的情况还可能继续添加num长度判断是否满足
            if(size >= 2 && num > temp.get(size-1) + temp.get(size-2))
                break;
            else if(size < 2 || (num == temp.get(size-1) + temp.get(size-2))) {
                temp.add((int)num);
                bktrace(s, ret, temp, i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
}