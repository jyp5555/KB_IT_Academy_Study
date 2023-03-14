package JavaAlgorithm.day09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class mergeSortPrac {
	static int[] buff;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[] numArr = new int[N];
		buff = new int[N];
		
		for(int i = 0; i < N ; i++) {
			numArr[i] = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
		}
		
		mergeSort(numArr,0,N-1);
		System.out.println(Arrays.toString(numArr));
		
		buff = null;
	}
	private static void mergeSort(int[] numArr, int start, int end) {
		if (start >= end) return;
		int center = (start+end)/2;
		int buffPointer = 0;
		int i = 0;
		int j = start;
		
		mergeSort(numArr,start, center);
		mergeSort(numArr, center+1, end);
		
		while(buffPointer < center+1) {
			buff[buffPointer++] = numArr[j++];
		}
		
		while(j <= end && i <= center) {
			numArr[start++] = buff[i] <= numArr[j] ? buff[i++] : numArr[j++];
		}
		
		while(i<=center) {
			numArr[start++] = buff[i++];
		}
	}

}
