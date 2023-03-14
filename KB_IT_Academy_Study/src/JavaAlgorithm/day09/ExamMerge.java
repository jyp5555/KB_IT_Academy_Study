package JavaAlgorithm.day09;

import java.util.Arrays;

public class ExamMerge {
	
	static int[] buff; // 병합을 위한 배열
	public static void main(String[] args) {
		buff = new int[8];
		mergeSortRecursive(new int[]{7,6,5,4,3,2,1,0},0,7);
		buff = null;
	}
	
	static void mergeSortRecursive(int[] numArray,int start, int end) {
		if(start >= end) return; // start 가 end를 역전하면, 분할된 배열 안 요소의 개수가 1, 0개이기 때문에 종료!
		else {
			int center = (start + end) /2; // 피봇 중심으로 나누기 위해!
			int i;
			int buffpointer = 0;
			int j = 0;
			int k = start;
		
			mergeSortRecursive(numArray,start,center);
			mergeSortRecursive(numArray,center+1, end);
			
			System.out.println(start+" "+ end);
			for(i = start ; i < center +1 ; i++) {
				buff[buffpointer++] = numArray[i];
			}

			while(i <= end && j < buffpointer) {
				numArray[k++] = (buff[j] <= numArray[i]) ? buff[j++] : numArray[i++];
			}
			
			while(j < buffpointer) {				
				numArray[k++]  = buff[j++];
			}
		}
	}
}
