import java.util.Arrays;
class OverlappingInterval{
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null || intervals != null && intervals.length == 0)
            return 0;
        Arrays.sort(intervals, (v1,v2) -> (v1[1]-v2[1]));
        int pre = 0;
        int deleted = 0;
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] >= intervals[pre][1]) {
                pre=i;
                continue;
            }
            deleted++;
        }
        return deleted;
    }
}