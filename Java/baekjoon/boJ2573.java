import java.io.*;
import java.util.*;

public class boJ2573 {
	static int N, M; // 세로, 가로
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] map;
	static boolean[][] check;
	static int answer;
	static int n = 0;

	// static int count; //덩어리 개수
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 첫줄에 빙산이 분리될때 while 문이 끝, 다 녹을 때까지 분리 되지 않으면, 끝내고 0 출력
		boolean state = true;

		answer = 0;
		int res = 0;
		
		while (state) {
			// 매년 새로 체크
			check = new boolean[N][M];
			int count = 0;
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < M; y++) {
					if (!check[x][y] && map[x][y] != 0) {
						DFS(x, y);
						count++;
						//System.out.println(count);
					}
				}
			}
		
			// 2개 이상으로 분리 될 때 바로 년도 출력
			if (count >= 2) {
				answer = res;
				state = false;
			} else if (count == 0) {
				answer = 0;
				state = false;
			}
			res++; //년도 카운트 
		}

		System.out.print(answer);
	}

	public static void DFS(int x, int y) {
		check[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			// 4방향 탐색 후 주변에 0 이면 값을 1 줄여줘야 한다.
			if (nx < 0 || nx >= N || ny < 0 || ny >= M || check[nx][ny])
				continue;

			if (map[nx][ny] == 0) {
				if (map[x][y] > 0)
					map[x][y]--;
			} else {
				DFS(nx, ny);
			}
		}

	}

}
