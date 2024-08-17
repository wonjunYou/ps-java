package history;

import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;

        long left = 1;
        long right = (long) n * Arrays.stream(times).max().getAsInt();
        long mid;

        while (left <= right) {
            mid = (left + right) / 2;

            if (check(n, times, mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    private boolean check(int n, int[] times, long mid) {
        long count = 0;

        for (int time : times) {
            count += (mid / time);
        }

        return count >= n;
    }
}
