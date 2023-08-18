package com.syeon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class swea1224 {

	static Stack<Character> stack;
	static char[] sentence;
	static String str; // 중위
	static String newstr; // 후위
	static Stack<Integer> newstack; // 후위 계산하는 스택
	static int result; // 최종 계산 결과

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 0; t < 10; t++) {
			stack = new Stack<>();
			newstack = new Stack<>();
			str = "";
			result = 0;
			int length = Integer.parseInt(br.readLine());
			str = br.readLine();
			// 후위 표기 법으로 변경하기
			for (int i = 0; i < length; i++) {
				postfix(str.charAt(i));
			}

			while (!stack.empty()) {
				newstr += stack.pop();
			}

			for (int i = 0; i < newstr.length(); i++) {
				calculate(newstr.charAt(i));
			}

			result = newstack.pop();
			System.out.println("#" + (t + 1) + " " + result);
		}

	}

	// 우선순위 조정
	public static int prior(char c) {
		int result = -1;
		if (c == '*')
			result = 2;
		else if (c == '+')
			result = 1;
		else
			result = 0;
		return result;

	}

	// 한 단어씩 스택에 저장하고...str에 저장하고..
	public static void postfix(char c) {
		if (c >= '0' && c <= '9') {
			newstr += String.valueOf(c);
		} else { // 연산자면..
			if (stack.empty()) {
				stack.push(c);
			} else {
				if (c == '(') {
					stack.push(c);
				} else if (c == ')') {
					while (!stack.empty() && stack.peek() != '(') {
						newstr += stack.pop();
					}
					stack.pop(); // '(' pop
				} else {
					while (!stack.empty() && prior(c) <= prior(stack.peek())) {
						newstr += stack.pop();
					}
					// 우선 순위 높으면 무조건 넣기
					stack.push(c);
				}
			}
		}

	}

	public static void calculate(char c) {
		System.out.println(newstr);
		if (c >= '0' && c <= '9') {
			newstack.push(c - '0');
		} else {
			if (c == '*') {
				int multi = newstack.pop() * newstack.pop();
				newstack.push(multi);
			} else if (c == '+') {
				int plus = newstack.pop() + newstack.pop();
				newstack.push(plus);
			}
		}
	}

}
