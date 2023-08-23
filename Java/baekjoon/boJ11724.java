import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boJ11724 {
	static int N;
	static int M;
	
	static int[][] graph;
	static boolean[] visited;
	static int count;
			
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			
			graph[x][y] = 1;
			graph[y][x] = 1;
		}
		count = 0;
		// 연결요소의 개수는 뭉탱이로 연결 되어있는 것만 개수 세도 됩니당. 
		for(int i = 1; i <= N; i++) {
			if(visited[i] == false) {
				count++;
				DFS(i);
			}
		}
		
		System.out.print(count);
		

	}
	
	public static void DFS(int start) {
		visited[start] = true;
		
		for(int i = 1; i <= N; i++) {
			if(visited[i] == false && graph[start][i] == 1) {
				DFS(i);
			}
		}
	}

}
