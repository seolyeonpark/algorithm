package com.syeon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boJ1476 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int e = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int cnt = 1;
		
		while(true) {
			if((e - cnt) % 15 == 0 && (s - cnt) % 28 == 0 && (m - cnt) % 19 == 0) {
				break;
			}
			cnt++;
		}
		
		System.out.println(cnt);

	}

}
