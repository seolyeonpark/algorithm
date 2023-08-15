package com.syeon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boJ10808 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		int[] arr = new int[26];
		
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			arr[c - 97]++; 
		}
		for(int i = 0; i < arr.length; i++) {
			sb.append(arr[i]).append(" ");
		}
		
		System.out.print(sb);

	}

}
