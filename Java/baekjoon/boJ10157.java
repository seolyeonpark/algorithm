package com.syeon.java;

import java.util.*;
import java.io.*;

public class boJ10157 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int C = Integer.parseInt(st.nextToken()); // 가로 
		int R = Integer.parseInt(st.nextToken()); // 세로 
		
		int K = Integer.parseInt(br.readLine()); // 관객 대기번호 
		
		if(K > C * R) {
			System.out.print(0);
			return;
		}
		// 기존배열 처럼 방향 탐색 정해둠 (마지막에 빼서 출력하면 되니까...)
		int dx[] = { -1, 0, 1, 0 };
		int dy[] = { 0, 1, 0, -1 };
		
		
		boolean[][] visited = new boolean[R][C];
		// 0에서 시작하니까 
		int cnt = 1, x = R - 1, y = 0, dir = 0;
		
		
		// K만큼 탐색해준다.
		while(cnt != K) {
			// 처음 방
			visited[x][y] = true;
			
			// dir은.. 벽에 부딪혔을때 바꾸어 줍니다. 
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			// 범위 밖일때는 
			if(nx < 0 || nx >= R || ny < 0 || ny >= C || visited[nx][ny]) {
				dir = ++dir % 4; // 원소 4개.. 다시 0으로 변경 
				nx = x + dx[dir];
				ny = y + dy[dir];
			}
			
			x = nx;
			y = ny;
			cnt++;
		}
		
		System.out.println((y+1) + " " + (R - x));
		
		

	}

}
