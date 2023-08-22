package com.syeon.java;

import java.util.*;
import java.io.*;

public class boJ2578 {

	public static int[][] bingo = new int[5][5];
	public static int[][] answer = new int[5][5];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				bingo[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				answer[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < 25; i++) {
			int ans = answer[i / 5][i % 5];
			for (int a = 0; a < 5; a++) {
				for (int b = 0; b < 5; b++) {
					if (bingo[a][b] == ans) {
						bingo[a][b] = 0;

						
					}
				}
			}
			
			if (bingo() == true) {
				System.out.print(i+1);
				return;
			}

		}

	}

	// 빙고 체크 해주기 , 빙고면 true 출력 아니면 false
	public static boolean bingo() {
		int bingocount = 0;
		// 가로 빙고 체크
		for (int i = 0; i < 5; i++) {
			int sum = 0;
			for (int j = 0; j < 5; j++) {
				if(bingo[i][j] == 0)
					sum++;
			}
			if (sum == 5) {
				bingocount++;
			}
		}

		// 세로 빙고 체크
		for (int i = 0; i < 5; i++) {
			int sum = 0;
			for (int j = 0; j < 5; j++) {
				if(bingo[j][i] == 0)
					sum++;
			}
			if (sum == 5) {
				bingocount++;
			}
		}

		// 대각선 빙고 체크
		int s = 0;
		for (int i = 0; i < 5; i++) {
			if(bingo[i][i] == 0)
				s++;
		}
		if (s == 5) {
			bingocount++;
		}

		// 역대각선 빙고 체크 (루프가 한개니까 체크를 루프 밖에서 해주어야 했다.) 
		int m = 0;
		for (int i = 0; i < 5; i++) {
			if(bingo[i][4-i] == 0)
				m++;
		}
		if (m == 5) {
			bingocount++;
		}
		
		
		if (bingocount >= 3) {
			return true;
		}

		return false;
	}

}
