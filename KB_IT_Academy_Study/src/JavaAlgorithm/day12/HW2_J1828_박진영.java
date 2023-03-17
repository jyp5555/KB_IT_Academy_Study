package JavaAlgorithm.day12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class HW2_J1828_박진영{
	static int N;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().strip());
        ArrayList<Integer> answerList = new ArrayList<>();
        
        StringTokenizer st;
        
        int[][] minMax = new int[N][2];
        
        for(int i = 0 ; i < N ; i++) {
        	st = new StringTokenizer(br.readLine());
        	minMax[i][0] = Integer.parseInt(st.nextToken());
        	minMax[i][1]= Integer.parseInt(st.nextToken());
        }
       
        Arrays.sort(minMax, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return (o2[1]-o2[0])-(o1[1]-o1[0]);
			}
        });
        
        getCount(0);
        
        System.out.println(Arrays.deepToString(minMax));
    }

	private static void getCount(int i) {
		if(i == N) {
			return;
		}
		
	}
}