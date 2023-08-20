package com.syeon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class boJ2628 {
	static int row;
	static int col;
	static int count;
	static ArrayList<Integer> paper = new ArrayList<>();
	
	static ArrayList<Integer> garo = new ArrayList<>();
	static ArrayList<Integer> sero = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		row = Integer.parseInt(st.nextToken()); // 가로 
		col = Integer.parseInt(st.nextToken()); // 세로 
		
		count = Integer.parseInt(br.readLine());
		
		// 0 시작점 까지 넣어야 차이를 반환할 수 잇다. 
		garo.add(0);
		sero.add(0);
		
		
		for(int i = 0; i < count; i++) {
			st = new StringTokenizer(br.readLine());
			int direct = Integer.parseInt(st.nextToken());
			int point = Integer.parseInt(st.nextToken());
			if(direct == 0) {
				garo.add(point);
			}
			else 
				sero.add(point);
		}
		
		garo.add(col);
		sero.add(row); // 원본 도 추가해준다. 로직을 위해서.. 가장 큰것 추가. 왜냐면 안자를 수도 있으니까. 
		
		Collections.sort(garo);
		Collections.sort(sero); // 오름차순 정렬  
		
		for(int i = 1; i < garo.size(); i++) {
			// 가로로 자른다 = 세로 길이 가 줄어든다. 
			int nowsero = garo.get(i) - garo.get(i-1);
			
			for(int j = 1; j < sero.size(); j++) {
				int nowgaro = sero.get(j) - sero.get(j-1);
				
				
				paper.add(nowsero * nowgaro);
			}
		}
		Collections.sort(paper);
		System.out.println(paper.get(paper.size() -1));
	}

}
