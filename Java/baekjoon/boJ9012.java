package com.syeon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boJ9012 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		Stack<Character> stack;
		for (int i = 0; i < T; i++) {
			String str = br.readLine();
			stack = new Stack<>();
			for (int j = 0; j < str.length(); j++) {
				char c = str.charAt(j);

				if (c == '(') {
					stack.push(c);
				} else {
					if (stack.empty()) {
						stack.push(c);
					} else if (!stack.empty() && stack.peek() == '(') {
						stack.pop();
					}

				}
			}

			if (!stack.empty()) {
				sb.append("NO").append("\n");
			} else
				sb.append("YES").append("\n");
		}

		System.out.print(sb);
	}

}
