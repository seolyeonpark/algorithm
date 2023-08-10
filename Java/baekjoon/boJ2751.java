package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.Collections;

public class boJ2751 {

	// 제한 시간 2초,,,,o(n^2)가 나오면 시간초과가 난다.
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		// 시간초과
//		int[] arr = new int[N];

//		int max = 0;
//		int temp = 0;
//		for(int i = 0; i < N; i++) {
//			arr[i] = Integer.parseInt(br.readLine());
//			
//		}
//		
//		for(int i = 0; i < N; i++) {
//			for(int j = i+1; j < N; j++) {
//				if(arr[i] > arr[j]) {
//					temp = arr[i];
//					arr[i] = arr[j];
//					arr[j] = temp;
//				}
//			}
//		}

		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}

		Collections.sort(list);

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			sb.append(list.get(i)).append('\n');
		}

		System.out.print(sb);

	}

}
