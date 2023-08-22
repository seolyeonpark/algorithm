package com.syeon.java;

import java.io.*;
import java.util.*;

public class boJ2468 {
    static int[][] location;
    static boolean[][] visited;
    // 최대 크기를 static으로 빼줘야 할듯 
    static int num;
    static int answer = 0;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        num = Integer.parseInt(br.readLine());
        location = new int[num][num];
        
        
        int maxheight = 0;
        
        for(int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j= 0; j < num; j++) {
                location[i][j] = Integer.parseInt(st.nextToken());
                maxheight = Math.max(maxheight, location[i][j]);
            }
        }
        
       int count = 0;
        // 최대 높이까지 점점 수면 올라갈때 안전 영역 최대 개수를 반환한다. 
        for(int i = 0; i <= maxheight; i++) {
        	visited = new boolean[num][num];
        	count = 0;
        	for(int x = 0; x < num; x++) {
        		for(int y = 0; y < num; y++) {
        			// 해당 지역 높이가 더 높고, 아직 방문하지 않았으면 
        			if(location[x][y] > i && !visited[x][y]) {
        				BFS(x, y, i);
        				count++; // 방문했으니까 세준다. (지역 뭉탱이..)
        			}
        		}
        	}
        	
        	answer = Math.max(answer, count);
        	
        }
        
        // 안전 영역 최대 개수 print 
        System.out.print(answer);
    }
    
   
    // BFS 메소드 
    public static void BFS(int x, int y, int depth) {
    	int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
    	
    	// 큐는 정보 저장용.. 
    	Queue<int[]> queue = new LinkedList<int[]>();
    	queue.offer(new int[] {x,y});
    	
    	visited[x][y] = true; // 방문 처리
    	
    	while(!queue.isEmpty()) {
    		int[] d = queue.poll(); // 추출
    		int curx = d[0];
    		int cury = d[1];
    		
    		for(int i = 0; i < 4; i++) {
    			int nextx = curx + dx[i];
    			int nexty = cury + dy[i];
    			
    			if(nextx >= 0 && nextx < num && nexty >= 0 && nexty < num) {
    				if(!visited[nextx][nexty] && location[nextx][nexty] > depth) {
    					visited[nextx][nexty] = true;
    					queue.offer(new int[] {nextx, nexty});
    				}
    			}
    		}
    	}
    	
    }

}