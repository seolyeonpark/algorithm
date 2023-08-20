package com.syeon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class boJ2309 {
	
	static ArrayList<Integer> height = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		for(int i = 0; i < 9; i++) {
			int h = Integer.parseInt(br.readLine());
			height.add(h);
			sum += h;
		}
		
		Collections.sort(height);
		
		int first = 0, second = 0;
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < i; j++) {
				if(sum - height.get(i) - height.get(j) == 100) {
					first = i;
					second = j;
				}
			}
		}
		
		height.remove(first);
		height.remove(second);
		
		
		Collections.sort(height);
		
		for(int i = 0; i < height.size(); i++) {
			System.out.println(height.get(i));
		}
		

	}

}
