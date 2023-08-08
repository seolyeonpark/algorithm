
package com.ssafy.algo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boJ2422 {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N, M;
        boolean[][] dislike = new boolean[204][204];
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < M; i ++) {
        	
        	
            st = new StringTokenizer(br.readLine());
            
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            
            // 중복 허용x
            dislike[first -1][second - 1] = true;
            dislike[second -1][first - 1] = true;
            
            
        }
        
        int count = 0;
        for(int i = 0; i < N; i++) {
            for(int j = i+1; j< N; j++) {
                
                if(dislike[i][j]) {
                    continue;
                }
                for(int k = j+1; k < N; k++) {
                    if(dislike[j][k] || dislike[k][i]) {
                        continue;
                    }
                    count++;
                }
            }
        }
        
        System.out.println(count);

    }

}