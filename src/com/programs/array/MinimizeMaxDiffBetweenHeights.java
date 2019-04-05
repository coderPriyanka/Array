package com.programs.array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author Priyanka_Sarkar
 * 
 * PROBLEM STATEMENT :
 * 
 * Given heights of n towers and a value k. We need to either increase
 * or decrease height of every tower by k (only once) where k > 0. The
 * task is to minimize the difference between the heights of the tallest
 * and the shortest tower after modifications, and output this
 * difference.
 *
 */

public class MinimizeMaxDiffBetweenHeights {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		int k = in.nextInt();
		System.out.println(minimizeHeightDifference(arr, k));
		in.close();
	}

	private static int minimizeHeightDifference(int[] arr, int k) {
		Arrays.sort(arr);
		int minDiff = arr[arr.length - 1] - arr[0];
		int small = arr[0] + k;
		int big = arr[arr.length - 1] - k;
		if (small > big) {
			int temp = big;
			big = small;
			small = temp;
		}
		for (int i = 1; i < arr.length - 1; i++) {
			int add = arr[i] + k;
			int subtract = arr[i] - k;
			if (subtract >= small || add <= big) {
				continue;
			}
			if (big - subtract < add - small) {
				small = subtract;
			} else {
				big = add;
			}
		}
		return Math.min(minDiff, big - small);
	}

}

