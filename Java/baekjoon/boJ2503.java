package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boJ2503 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		boolean[] cntN = new boolean[1000];
		
		// 가능한 숫자 추리기 
		for (int i = 123; i <= 987; i++) {
			
			String num = Integer.toString(i);
			// 0들어간 숫자 불가...근데 두번째 세번째만 불가능하지 않나? 
			if (num.charAt(1) == '0' || num.charAt(2) == '0')
				continue; 
			
			// 숫자 자릿수 중복 불가 
			if (num.charAt(0) == num.charAt(1) || num.charAt(1) == num.charAt(2) || num.charAt(2) == num.charAt(0))
				continue; 
			
			cntN[i] = true;
		}
		

		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine());
			int number = Integer.parseInt(st.nextToken()); 
			
			//스트라이크랑 볼  
			int strike = Integer.parseInt(st.nextToken()); 
			int ball = Integer.parseInt(st.nextToken()); 

			for (int j = 123; j <= 987; j++) {
				//true
				if (cntN[j]) {
					int strikecnt = 0;
					int ballcnt = 0;

					// 자릿수 비교, char에 넣어서 한자리 씩 비교하기, 3자리니까 charAt으로 하나씩 나눠서 비교 
					// 입력 받은 숫자 : number
					for (int first = 0; first < 3; first++) {
						char checknum = Integer.toString(number).charAt(first);

						// j!! 가 돌아가면서 숫자 분리 후 비교 
						for (int second = 0; second < 3; second++) {
							char checkans = Integer.toString(j).charAt(second);
							
							
							
							// 둘다 같을때 
							if (first == second && checknum == checkans)
								strikecnt++; 
							// 자릿수만 다를 때 
							else if(first != second && checknum == checkans)
								ballcnt++; 
						}
					}
					
					//실제 결과와 비교해서 가능성 답 수정해주기 

					if (strikecnt == strike && ballcnt == ball)
						cntN[j] = true;
					else //false로 꼭 바꿔줘야함 
						cntN[j] = false;
				}
			}
		}
		//답 개수 계산 
		int cnt = 0;
		for (int i = 123; i <= 987; i++) {
			if (cntN[i])
				cnt++;
		}
		System.out.println(cnt);

	}

}
