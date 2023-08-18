package com.syeon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class boJ1918 {
	
	static Stack<Character> stack = new Stack<>();
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		// 입력받음
		String str = br.readLine();
		// 입력 받은 것을 가지고 길이만큼 루프, 숫자는 sb에 추가, 연산자는 stack 작업 
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(c >= 'A' && c <= 'Z') {
				sb.append(str.charAt(i));
			}
			
			else {
				// 괄호 양쪽 구문 부터 처리 
				if(c == '(') {
					stack.push(c);
				}
				else if(c == ')') {// 반대쪽이 나올때까지 꺼내주기 
					while(!stack.empty() && stack.peek() != '(') {
						sb.append(stack.pop());
					}
					// ( 꺼내주기 
					if(!stack.empty())
						stack.pop();
				}
				else { // 나머지 연산자일경우
					while(!stack.empty() && prior(stack.peek()) >= prior(c)) {
						sb.append(stack.pop());
					}
					stack.push(c);
					
				}
				
			}
		}
		
		while(!stack.empty()) {
			sb.append(stack.pop());
			
		}
		
		System.out.println(sb);
	}
	
	// 연산자 우선순위 만들어줌... 
	public static int prior(char c) {
		int result = -1;
		if(c == '*' || c== '/') {
			result = 2;
		}
		else if(c == '+' || c == '-') {
			result = 1;
		}
		else if(c == '(') {
			result = 0;
		}
		return result;
		
	}

}
