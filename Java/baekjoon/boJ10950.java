package com.syeon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boJ10950 {

	public static void main(String[] args) throws NumberFormatException, IOException {
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			//stringbuilder에 append 후 한꺼번에 계산해준다. a+b
			sb.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()));
			
			sb.append('\n');
			
		}
		
		System.out.println(sb);

	}

}
