
package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boJ5212 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] dx = { 0, 0, 1, -1 };
		int[] dy = { 1, -1, 0, 0 };

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		char[][] map = new char[R][C];
		char[][] temp = new char[R][C];

		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			map[i] = s.toCharArray();
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				temp[i][j] = map[i][j];
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'X') {

					int count = 0;

					for (int k = 0; k < dx.length; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];

						// 지도 내부 X아니고 물이 3 이상이면,,,,,, .으로 변경
						if ((nx >= 0 && nx < R && ny >= 0 && ny < C)) {
							if (map[nx][ny] == 'X') {
								continue;
							}
						}
						count++;
					}

					if (count >= 3) {
						temp[i][j] = '.';
					}
				}
			}
		}

		// 출력할 범위 구하기

		int lx = Integer.MAX_VALUE;
		int ly = Integer.MAX_VALUE;
		int rx = Integer.MIN_VALUE;
		int ry = Integer.MIN_VALUE;

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (temp[i][j] == 'X') {
					lx = Math.min(i, lx);
					ly = Math.min(j, ly);
					rx = Math.max(i, rx);
					ry = Math.max(j, ry);
				}
			}
		}

		// 최종 지도 출력 !!!!
		StringBuilder sb = new StringBuilder();

		for (int i = lx; i <= rx; i++) {

			for (int j = ly; j <= ry; j++) {
				sb.append(temp[i][j]);
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}
}