package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boJ9455 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st;
	        int T = Integer.parseInt(br.readLine());

	        
	        for(int a = 0; a < T; a++){
	        	st = new StringTokenizer(br.readLine(), " ");
	            
	            int m = Integer.parseInt(st.nextToken());
	            int n = Integer.parseInt(st.nextToken());

	            int[][] box = new int[m][n];

	            
	            for (int i = 0; i < m; i++) {
	                st = new StringTokenizer(br.readLine(), " ");
	                for (int j = 0; j < n; j++)
	                    box[i][j] = Integer.parseInt(st.nextToken());
	            }
	            
	            int count = 0; 
	            // 이동거리 계산
	            for (int i = 0; i < n; i++) {
	                for (int j = 0; j < m; j++) {
	                    // 박스가 있음 
	                    if (box[j][i] == 1) {
	                        // 현재위치 바로 아래 칸부터 1 나오기 전까지 더해줘용 
	                        for (int k = j + 1; k < m; k++) {
	                            if (box[k][i] == 0)
	                                count++;
	                        }
	                    }
	                }
	            }
	            System.out.println(count);
	        }

	}

}
