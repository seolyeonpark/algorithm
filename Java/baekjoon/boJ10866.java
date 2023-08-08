package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class boJ10866 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Deque<Integer> deque = new LinkedList<>();
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			// 명령 입력 받기
			String s = st.nextToken();

			// push front
			if (s.equals("push_front")) {

				deque.addFirst(Integer.parseInt(st.nextToken()));

			} 
			//push back
			else if (s.equals("push_back")) {

				deque.addLast(Integer.parseInt(st.nextToken()));

			} 
			//pop front
			else if (s.equals("pop_front")) {

				if (deque.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(deque.pollFirst()).append("\n");
				}

			} 
			//pop back
			else if (s.equals("pop_back")) {

				if (deque.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(deque.pollLast()).append("\n");
				}

			} 
			//size
			else if (s.equals("size")) {

				sb.append(deque.size()).append("\n");

			} 
			//empty
			else if (s.equals("empty")) {

				if (deque.isEmpty()) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}

			} 
			//front
			else if (s.equals("front")) {

				if (deque.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(deque.getFirst()).append("\n");
				}

			} 
			//back
			else if (s.equals("back")) {

				if (deque.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(deque.getLast() + "\n");
				}
			}
		}

		System.out.println(sb);
	}

}
