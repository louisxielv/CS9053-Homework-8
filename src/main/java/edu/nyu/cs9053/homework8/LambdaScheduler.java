package edu.nyu.cs9053.homework8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaScheduler {
	public List<LambdaJob> scheduel(List<LambdaJob> jobs) {
		if (jobs == null || jobs.size() == 0) {
			return jobs;
		}
		// sort jobs by the endTime
		Collections.sort(jobs, new Comparator<LambdaJob>(){
			public int compare(LambdaJob job1, LambdaJob job2){
				return job1.getEndTime() - job2.getEndTime();
			}
		});

		List<LambdaJob> result = new ArrayList<>();
		result.add(jobs.get(0));

		// store the index of last selected job
		int lastSelectedJob = 0;

		// use the greedy algorithm to pick job
		for (int i = 1; i < jobs.size(); i++) {
			if (jobs.get(i).getStartTime() > jobs.get(lastSelectedJob).getEndTime()) {
				result.add(jobs.get(i));
				lastSelectedJob = i;
			}
		}

		return result;
	}
}