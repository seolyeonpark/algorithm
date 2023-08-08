package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;




class Balloon {
	int index, move;

	Balloon(int index, int move) {
		this.index = index;
		this.move = move;
	}
}

public class boJ2346 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		// Deque<Integer> deque = new LinkedList<>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		Deque<Balloon> que = new ArrayDeque<>();

		// N입력
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());

		// 풍선 맹글어주기
		for (int i = 1; i <= N; i++) {
			int move = Integer.parseInt(st.nextToken());
			que.addLast(new Balloon(i, move));
		}

		while (!que.isEmpty()) {
			// 맨앞부터 터뜨림 -> get 후에 poll 해주면 될듯?
			sb.append(que.getFirst().index).append(' ');
			int move = que.pollFirst().move;
			// 1개만(예외)있었으면
			if (que.isEmpty()) {
				break;
			}

			// + , - 로직

			// 점점 오른쪽
			if (move > 0) {
				move = move - 1;
				for (int i = 0; i < move; i++) {
					que.addLast(que.pollFirst());
				}
			}
			// 점점 왼쪽
			else {
				for (int i = move; i < 0; i++) {
					que.addFirst(que.pollLast());
				}
			}
		}
		System.out.println(sb.toString());
	}
}