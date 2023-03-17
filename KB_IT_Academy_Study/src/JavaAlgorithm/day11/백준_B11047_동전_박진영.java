package JavaAlgorithm.day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_B11047_동전_박진영 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] money = new int[N];
		for (int i = 0;i<N ; i++) {
			money[i] = Integer.parseInt(br.readLine().strip());
		}
		int count = 0;
		for(int i = N-1; i >= 0 ; i--) {
			if(K / money[i] > 0) {
				count += K/money[i];
				K = K%money[i];	
			}
		}
		
		System.out.println(count);

	}

}
