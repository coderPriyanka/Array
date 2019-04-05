package com.programs.array;

/**
 * 
 * @author Priyanka_Sarkar
 *
 */

public class LargestSumSubarray {

	private int startIndex;
	private int endIndex;

	public int findLargestSumSubarray(int[] arr) {
		int localMax = arr[0];
		int globalMax = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[i] + localMax) {
				localMax = arr[i];
				if (localMax > globalMax) {
					startIndex = endIndex = i;
				}
			} else {
				localMax += arr[i];
				if (localMax > globalMax) {
					endIndex = i;
				}
			}
			globalMax = Math.max(localMax, globalMax);
		}
		return globalMax;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public int getEndIndex() {
		return endIndex;
	}
}

