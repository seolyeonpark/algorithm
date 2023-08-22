package com.syeon.java;

import java.util.*;
import java.io.*;

public class boJ2669 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[][] arr = new int[101][101];

		//st = new StringTokenizer(br.readLine(), " ");
		// 1줄씩 4번, 그리고 1케이스만 받으므로 루프는 1번만 돌기 
		for (int j = 0; j < 4; j++) {
			st = new StringTokenizer(br.readLine(), " ");
			int lx = Integer.parseInt(st.nextToken());
			int ly = Integer.parseInt(st.nextToken());

			int rx = Integer.parseInt(st.nextToken());
			int ry = Integer.parseInt(st.nextToken());

			for (int a = lx; a < rx; a++) {
				for (int b = ly; b < ry; b++) {
					arr[a][b] = 1;
				}
			}
		}

		int count = 0;

		for (int i = 1; i < 101; i++) {
			for (int j = 1; j < 101; j++) {
				if (arr[i][j] == 1)
					count++;
			}
		}

		System.out.print(count);

	}

}
