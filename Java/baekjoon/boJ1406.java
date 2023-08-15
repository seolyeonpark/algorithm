package com.syeon.java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class boJ1406 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Stack<Character> left = new Stack<Character>();
		Stack<Character> right = new Stack<Character>();

		String str = br.readLine();
		for (int i = 0; i < str.length(); i++) {
			left.push(str.charAt(i));
		}

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {

			String order = br.readLine();
			if (order.equals("L")) {

				if (!left.empty()) {
					right.push(left.pop());
				}
			} else if (order.equals("D")) {

				if (!right.empty()) {
					left.push(right.pop());
				}
			} else if (order.equals("B")) {

				if (!left.empty()) {
					left.pop();
				}
			} else if (order.startsWith("P")) {
				char c = order.charAt(2);

				left.push(c);
			}

		}

		while (!left.empty()) {
			right.push(left.pop());
		}

		while (!right.empty()) {
			bw.write(right.pop());
		}

		// 시간 초과 때문에..bw 사용했습니다..
		br.close();
		bw.flush();
		bw.close();
	}

}
