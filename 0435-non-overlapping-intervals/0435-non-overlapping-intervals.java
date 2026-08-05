class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        if (intervals.length == 0)
            return 0;

        // Sort by ending time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int remove = 0;
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            // Overlap
            if (intervals[i][0] < end) {
                remove++;
            } else {
                // No overlap
                end = intervals[i][1];
            }
        }

        return remove;
    }
}