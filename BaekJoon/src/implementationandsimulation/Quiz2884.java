package implementationandsimulation;

import java.io.*;
import java.util.*;

/*
 * 입력받은 분이 45보다 작으면 시를 1씩 감소시켜야 함
 * 이때, 입력받은 시가 0이면 23으로 설정해야함
 */

public class Quiz2884 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int hour = Integer.parseInt(st.nextToken());
		int min = Integer.parseInt(st.nextToken());
		
		min -= 45;
		
		if (min < 0) {
			hour--;
			min += 60;
		}
		
		if (hour < 0) {
			hour = 23;
		}
		
		System.out.println(hour + "시 " + min + "분");
		
	}
	
}
