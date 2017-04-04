package edu.nyu.cs9053.homework8;

public class LambdaJob {
	private final int startTime;
	private final int endTime;
	private final int label;

	public LambdaJob (int startTime, int endTime, int label) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.label = label;
	}

	public int getStartTime() {
		return startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public int getLabel() {
		return label;
	}
}