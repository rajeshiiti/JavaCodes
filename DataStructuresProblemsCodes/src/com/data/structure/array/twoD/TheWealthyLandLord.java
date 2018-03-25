package com.data.structure.array.twoD;

import java.util.Scanner;

public class TheWealthyLandLord {
	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		int n = inp.nextInt();
		int[][] land = new int[1001][1001];
		for (int i = 1; i <= 1000; i++) {
			for (int j = 1; j <= 1000; j++) {
				land[i][j] = 0;
			}
		}
		int[][] inputs = new int[n+1][5];
		for (int i = 1; i <= n; i++) {
			inputs[i][0] = inp.nextInt();
			inputs[i][1] = inp.nextInt();
			inputs[i][2] = inp.nextInt();
			inputs[i][3] = inp.nextInt();
			inputs[i][4] = inp.nextInt();
			setCompansation(land, inputs, i);
		}
		System.out.println(getCompansation(land, inputs, n));

		inp.close();

	}

	public static void setCompansation(int[][] land, int[][] inputs, int k) {
		for (int i = inputs[k][0]; i <= inputs[k][2]; i++) {
			for (int j = inputs[k][1]; j <= inputs[k][3]; j++) {
				if (land[i][j] == 0) {
					land[i][j] = 1;
				} else if (land[i][j] == 1) {
					land[i][j] = -1;
				}
			}
		}
	}

	public static long getCompansation(int[][] land, int[][] inputs, int n) {
		long cost = 0L;
		for (int k = 1; k <= n; k++) {
			for (int i = inputs[k][0]; i <= inputs[k][2]; i++) {
				for (int j = inputs[k][1]; j <= inputs[k][3]; j++) {
					if (land[i][j] == -1) {
						cost = cost + (long)inputs[k][4];
					}
				}
			}
		}
		return cost;
	}
}
