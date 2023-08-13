package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boJ14503 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		int N, M;
		int map[][];

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		st = new StringTokenizer(br.readLine());
		int Rr = Integer.parseInt(st.nextToken());
		int Rc = Integer.parseInt(st.nextToken());
		int Rd = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		

		int count = 0;
		while (true) {

			// 현재 청소 가능
			if (map[Rr][Rc] == 0) {
				count++;
				map[Rr][Rc] = -1;
			}

			// 4방향 탐색 -> 청소 가능 한가? ,, nynx 좌표
			boolean check = false;
			for (int i = 0; i < 4; i++) {
				// 초기 rr, rc는 처음 청소기있는곳
				int ny = Rr + dr[i];
				int nx = Rc + dc[i];
				if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
					if (map[ny][nx] == 0)
						check = true;
				}
			}
			
			
			

				// 주변 4방향 중 청소 안된 곳 있음 -> 3번 조건 실행
			if (check) {
				// 반시계 회전 d
				if (Rd > 0)
					Rd -= 1;
				// 서쪽
				else
					Rd = 3;

				// 청소 되지 않은 빈칸인 경우 이동 !!!
				int ny = Rr + dr[Rd];
				int nx = Rc + dc[Rd];
				if (ny >= 0 && ny < N && nx >= 0 && nx < M) {

					if (map[ny][nx] == 0) {
						Rr = ny;
						Rc = nx;
					}
				}

				// 4방향 전부 청소 되었을 때 2 번 조건 달성
			} else {

				// 후진 헷갈렬어려러 ,,,,,,,,,,뒷방향 찾다가 지웟어
				// 후진 체크 해서 벽 아니면 완전히 이동 !!!!

				int ny = Rr - dr[Rd];
				int nx = Rc - dc[Rd];
				
				if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
					if (map[ny][nx] != 1) {
						Rr = ny;
						Rc = nx;
					} else {
						break;
					}
				}
			}
		}

		
		
		System.out.println(count);
	}
}
