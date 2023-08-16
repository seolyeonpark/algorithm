package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boJ2960 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N, K;

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		// false로 초기화
		boolean[] visited = new boolean[N + 1];
		int count = 0;
		for (int i = 2; i < N + 1; i++) {

			if (visited[i] == false) {

				// P와 P배수 지우기
				for (int j = i; j < N + 1; j += i) {
					if (visited[j] == false) {
						visited[j] = true;
						count++;
					}
					if (count == K) {
						System.out.print(j);
						break;
					}
				}
			}

		}

	}

}