package com.syeon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boJ2559 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N, K;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int max = Integer.MIN_VALUE; // 초깃값은 엄청 작은 숫자로 
		for(int i = 0; i < N - K + 1; i++) {
			int sum = 0; // 연속적 횟수만큼 더해
			// i부터 k 만큼 더해줘야한다. 
			for(int j = i; j < i + K; j++) {
				sum += arr[j];
			}
			
			max = Math.max(max, sum);
		}
		
		System.out.print(max);
	}

}
