package com.syeon.java;
import java.io.*;
import java.util.*;


public class boJ14696 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		next : for(int i = 0; i < N; i++) {
			// 루프 내부 지역으로 턴마다 비교하기 때문에 맹글어야대
			int[] A = new int[5];
			
			int[] B = new int[5];
			
			st = new StringTokenizer(br.readLine());
			int round = Integer.parseInt(st.nextToken());
			
			for(int j = 0; j < round; j++) {
				int index = Integer.parseInt(st.nextToken());
				A[index] ++;
			}
		
		
			st = new StringTokenizer(br.readLine());
			round = Integer.parseInt(st.nextToken());
			
			for(int j = 0; j < round; j++) {
				int index = Integer.parseInt(st.nextToken());
				B[index] ++;
			}
			
			for(int j = 4; j > 0; j--) {
				if(A[j] > B[j]) {
					sb.append("A").append("\n");
					continue next;
				}
				else if(A[j] < B[j]) {
					sb.append("B").append("\n");
					continue next;
				}
			}
			
			
			sb.append("D").append("\n");
		
		}
		
		
		System.out.println(sb);
		
		
	}

}
