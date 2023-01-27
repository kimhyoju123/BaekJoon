package implementationandsimulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Quiz2490 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		// D : 윷 , C : 걸 , B : 개 , A : 도 , E : 모
		String[] strArr = {"D", "C", "B", "A", "E"};
		
		for (int i = 0; i < 3; i++) {
			
			String str = br.readLine();
			
			// StringTokenizer : 구분자 \t\n\r\f 를 통해서 토큰 형태로 나눔
			StringTokenizer st = new StringTokenizer(str);
			
			int sum = 0;
			
			while (st.hasMoreTokens()) {
				sum += Integer.parseInt(st.nextToken());
			}
			
			sb.append(strArr[sum] + "\n");
			
		}
		
		System.out.println(sb);
		
	}
	
}
