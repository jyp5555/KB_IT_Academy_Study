package JavaAlgorithm.day06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_B11660_구간합구하기5_박진영 {

	public static void main(String[] args) throws IOException {
		int N = 0;
		int M = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //bufferReader는 한번만 부르자! Scanner랑 마찬가지로
		StringTokenizer st = new StringTokenizer(br.readLine());
		if(st.hasMoreTokens()) N = Integer.parseInt(st.nextToken());
		if(st.hasMoreTokens()) M = Integer.parseInt(st.nextToken());

		
		int[][] matrix = new int[N+1][N+1];
		for (int i = 1; i < N+1 ;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =1 ; j<N+1;j++) {
				if(st.hasMoreTokens()) matrix[i][j] = Integer.parseInt(st.nextToken());
			}
			System.out.println(Arrays.toString(matrix[i]));
		}
	
		for(int i = 1; i<N+1;i++) {
			for(int j = 1;j<N+1;j++) {
				matrix[i][j] = matrix[i-1][j] + matrix[i][j-1] - matrix[i-1][j-1] + matrix[i][j];
			}
			System.out.println(Arrays.toString(matrix[i]));
		}
		
		for(int i = 0; i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int[] res = new int[4];
			for(int j = 0; j < 4 ; j++) {
				if(st.hasMoreTokens()) res[j] = Integer.parseInt(st.nextToken());
			}
			System.out.println(matrix[res[2]][res[3]]-matrix[res[2]][res[1]-1]-matrix[res[0]-1][res[3]] + matrix[res[0]-1][res[1]-1]);
			
		}
		
		
	}
}
