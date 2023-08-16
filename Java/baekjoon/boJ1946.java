package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boJ1946 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		
		
		for (int i = 0; i < T; i++) {
			
			int N = Integer.parseInt(br.readLine());
			// N까지 저장해야됩니다 
			int[] arr = new int[N + 1];

			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				int docu = Integer.parseInt(st.nextToken());
				arr[docu] = Integer.parseInt(st.nextToken());
			}
			int result = 1;
			int min = arr[1];
			
			// 면접 점수 더 높은 사람 생길때마다 채용이 가능 
			for (int j = 2; j <= N; j++) {
				if (arr[j] < min) {
					min = arr[j];
					result++;
				}
			}
			sb.append(result).append("\n");;
			
		}
		System.out.println(sb);
	}

}
