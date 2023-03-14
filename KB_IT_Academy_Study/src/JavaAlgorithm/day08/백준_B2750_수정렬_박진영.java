package JavaAlgorithm.day08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_B2750_수정렬_박진영 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];int[] arr1 = new int[n];int[] arr2 = new int[n];int[] arr3 = new int[n];
		for(int i = 0; i < n; i++) {
			int m = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
			arr[i] = m;
			arr1[i] = m;
			arr2[i] = m;
			arr3[i] = m;
		}
		
		bubbleSort(arr);
		selectionSort(arr1);
		insertionSort(arr2);
		
//		int c = a++ + ++a + a++ + ++a; == 1[2]+([2]+1)+3[4]+([4]+1)
//		System.out.println(a+", "c); => 5, 12
		
		int[] arr4 = {5, 7, 1, 4, 6, 2, 3, 9, 8};		
		int[] arr5 = {77,67,20,63,13};

		selectionSort(arr5);
		quickSort2(arr4,0,arr4.length-1);
	}
	
	static void bubbleSort(int[] arr) {
		System.out.println(Arrays.toString(arr));
		for(int i = 0; i < arr.length ; i++) {
			for (int j = 0; j < arr.length-i -1 ; j++) {
				if(arr[j+1] < arr[j]) {
					int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		for(int a : arr) System.out.println(a);
	}
	
	static void selectionSort(int[] arr) {
		
		for(int i = 0; i < arr.length - 1 ; i++) {//맨끝에는 어차피 가장 큰 값이 감, 정렬할 필요 없음
			int min = i;
			for(int j = i+1; j < arr.length ; j++) {
				if(arr[min] > arr[j]) {min = j;}
			}
			int temp = arr[i];
	        arr[i] = arr[min];
	        arr[min] = temp;
		}
		
		for(int a : arr) System.out.println(a);
	}
	
	static void insertionSort(int[] arr) {
		for(int i = 1; i<arr.length;i++) {
			for(int j = 0 ; j < i ; j++) {
				if(arr[j]>arr[i]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		for(int a : arr) System.out.println(a);
	}
	
	static void quickSort(int[] arr, int left, int right) {
		
		int start = left;
		int end = right;
		int pivot = arr[(left + right) /2];
		
		while(left <= right) {
			while(arr[left] < pivot) left++;
			while(arr[right] > pivot) right--;
			
			if(left <= right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++; right--;
			}
			System.out.println(Arrays.toString(arr));

		}

		System.out.println(Arrays.toString(arr));
		
		if (start < right) quickSort(arr,start,right);
		if(left < end) quickSort(arr,left,end);
		
	
	}
	static void quickSort2(int[] arr, int left, int right) {
		int pl = left;
		int pr = right;
		int pivot = arr[(left + right) /2];
		
		do {
			while(arr[pl]<pivot) pl++;
			while(arr[pr]>pivot) pr--;
			
			int temp = arr[pl];
			arr[pl] = arr[pr];
			arr[pr] = temp;
			
		}while(pl < pr);
		System.out.println(Arrays.toString(arr));

		if(left < pr) quickSort(arr,left, pr);
		if(pl < right) quickSort(arr,pl,right);

	}
}

