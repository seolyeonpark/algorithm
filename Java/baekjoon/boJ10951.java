package com.syeon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boJ10951 {
	public static void main(String[] args) throws IOException {

		// 입력에서 더이상의 읽을 수 있는 데이터가 존재하지 않을 때 반복문을 종료 -> EOF
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		String str;

		int A, B;
		while ((str = br.readLine()) != null) {

			st = new StringTokenizer(str, " ");
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());

			sb.append(A + B).append('\n');

		}

		System.out.print(sb);
	}
}
