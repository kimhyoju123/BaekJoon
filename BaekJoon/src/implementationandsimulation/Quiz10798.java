package implementationandsimulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
1. 입력을 받기 위해서는 Scanner보다 BufferedReader를 사용하는 것이 좋다.
2. 한 줄 입력이 여러번 들어오는 경우에는 split보다 StringTokenizer를 사용하여 파싱하는 것이 좋다.
3. 여러 번 출력해야 하는 경우에는 StringBuilder를 사용해 한번에 출력하는 것이 것이 좋다.
4. Array를 사용하는 것보다 ArrayList를 사용하는 것이 좋다.
5. ArrayList를 정렬하기 위해서는 Collections.sort()를 사용한다.
6. 배열을 초기화하기 위해서는 java.util.Arrays의 Arrays.fill(배열, 초기화값)을 사용한다.
7. 연속으로 있는 숫자를 입력받기 위해서는 1번 대신에 2번을 사용하자 ex) 10111010101
	1. String[] inputs = br.readLine().split(""); 
	2. br.read() - '0';
*/

public class Quiz10798 {

	public static void main(String[] args) throws Exception {

		char[][] ch = new char[5][15];
		int max = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
		StringBuilder sb = new StringBuilder(); // 출력
		
		for (int i = 0; i < ch.length; i++) { // 5번 반복 / 5줄 입력 받아서 

			String str = br.readLine(); // return String / throws IOException

			if (max < str.length()) { // 입력 받은 5줄 중 가장 길이가 긴 문자열의 크기 구함
				max = str.length();
			}

			for (int j = 0; j < str.length(); j++) {
				ch[i][j] = str.charAt(j);
			}

		}

		for (int i = 0; i < max; i++) {
			for (int j = 0; j < 5; j++) {
				if (ch[j][i] == '\0') {
					continue;
				}
				sb.append(ch[j][i]);
			}
		}
		
		System.out.println(sb);

	} // main

} // class
