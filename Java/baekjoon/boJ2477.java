package com.syeon.java;


import java.util.*;
import java.io.*;


public class boJ2477 {
	public static int[] length = new int[6];
	
	public static int K, maxWidth, maxHeight, indexw, indexh;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		K = Integer.parseInt(br.readLine());
		
		
		maxWidth = Integer.MIN_VALUE;
		maxHeight = Integer.MIN_VALUE;
		
		for(int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			int direct = Integer.parseInt(st.nextToken());
			
			length[i] = Integer.parseInt(st.nextToken());
			// 최대 가로 구하기 
			if(direct == 1 || direct == 2) {
				if(maxWidth < length[i]) {
					maxWidth = length[i];
					indexw = i;
				}
			}
			
			if(direct == 3 || direct == 4) {
				if(maxHeight < length[i]) {
					maxHeight = length[i];
					indexh = i;
				}
			}
			
		}
		
		int smallwidth = lengcal(indexw);
		int smallheight = lengcal(indexh);
		
		
		int result = (maxWidth * maxHeight - smallwidth * smallheight) * K;
		
		System.out.print(result);

	}
	// ㄱ자 모양이기 때문에 최대 가로 세로 바로 양 옆 값의 차를 이용해서 구할 수 있다. 가로 세로 전부 적용 가능 
	public static int lengcal(int index) {
		int l = 0;
		if(index == 5) {
			l = Math.abs(length[index - 1] - length[0]);
		}
		else if(index == 0) {
			l = Math.abs(length[index + 1] - length[5]);
		}
		else {
			l = Math.abs(length[index - 1] - length[index + 1]);
		}
		return l;
	}
	
	

}
