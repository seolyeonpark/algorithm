package com.syeon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boJ11651 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			
			
		}
		
		
		// 무조건 증가하는 순서로 정렬인데, y좌표가 증가하는 순서가 우선이기 때문에 1이 같으면 0을 증가하는 순서로 조정해야대요 
		Arrays.sort(arr, (e1, e2) -> {
			if(e1[1] == e2[1]) {
				return e1[0] - e2[0];
			}
			else
				return e1[1] - e2[1];
		});
		
		for(int i = 0; i < N; i++) {
			sb.append(arr[i][0] + " " + arr[i][1]).append("\n");
		}
		System.out.print(sb);
	}

}
