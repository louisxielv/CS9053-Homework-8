package edu.nyu.cs9053.homework8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by LyuXie on 4/4/17.
 */
public class LambdaWeightedScheduler {
    public int scheduel(List<LambdaJob> jobs) {
        if (jobs == null || jobs.size() == 0) {
            return 0;
        }
        // sort jobs by the endTime
        Collections.sort(jobs, new Comparator<LambdaJob>(){
            public int compare(LambdaJob job1, LambdaJob job2){
                return job1.getEndTime() - job2.getEndTime();
            }
        });

        int[] dp = new int[jobs.size() + 1];
        dp[0] = 0;
        dp[1] = jobs.get(0).getWeight();

        // use the DP algorithm to pick job
        // dp[i] = Math.max(dp[j] + jobs.get(i).getWeight(), dp[i - 1])
        // j is the the last position with j.endTime <= i.startTIme
        // use binary search to find j
        for (int i = 2; i <= jobs.size(); i++) {
            int j = binarySearch(0, i - 2, jobs, jobs.get(i - 1).getStartTime());
            dp[i] = Math.max(dp[j + 1] + jobs.get(i - 1).getWeight(), dp[i - 1]);
        }

        return dp[dp.length - 1];

    }

    private int binarySearch(int start, int end, List<LambdaJob> jobs, int target) {
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (jobs.get(mid).getEndTime() > target) {
                end = mid;
            }
            else {
                start = mid;
            }
        }

        if (jobs.get(end).getEndTime() <= target) {
            return end;
        }
        if (jobs.get(start).getEndTime() <= target) {
            return start;
        }
        else {
            return -1;
        }


    }
}
