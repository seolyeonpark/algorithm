import java.io.*;
import java.util.*;

public class boJ2468dfs {
	static int[][] location;
	static boolean[][] visited;
	static int num;
	static int answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		num = Integer.parseInt(br.readLine());
		location  = new int[num][num];
		
		int maxheight = 0; 
		
		
		for(int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < num; j++) {
				// location 내부 값이 각 지역의 높이를 나타냄 
				location[i][j] = Integer.parseInt(st.nextToken());
				maxheight = Math.max(maxheight, location[i][j]);
			}
		}
		
		int count = 0;
		answer = 0;
		for(int i = 0; i < maxheight; i++) {
			// 2차원 배열 탐색 필요
			count = 0;
			visited = new boolean[num][num];
			for(int x = 0; x < num; x++) {
				for(int y = 0; y < num; y++) {
					if(!visited[x][y] && location[x][y] > i) {
						DFS(x,y,i);
						
						count++;
						//System.out.println("count: " + count);
					}
				}
			}
			
			answer = Math.max(answer, count);
			
		}
		
		System.out.print(answer);
		
		
	}
	
	public static void DFS(int x, int y, int depth) {
		int[] dx = {-1, 0, 1, 0};
		
		// 방향벡터 틀린걸 모르고 30분 날리다. . . . 
		int[] dy = {0, 1, 0, -1};
		
		visited[x][y] = true;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || nx >= num || ny < 0 || ny >= num) {
				continue;
			}
			
			if(!visited[nx][ny] && location[nx][ny] > depth) {
				// 해당 수면에 맞는 안전 지역 탐색.. 
				DFS(nx, ny, depth);
			}
			
		}
		
		
	}

}
