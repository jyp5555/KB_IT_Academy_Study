package JavaAlgorithm.day08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_B24090_퀵정렬1_박진영 {
	static ArrayList<node> nodes;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		nodes = new ArrayList<>();
		int N = Integer.parseInt(st.nextToken());
		long K = Long.parseLong(st.nextToken());
		
		long[] nums = new long[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0 ; i < N ; i++) {
			nums[i] = Long.parseLong(st.nextToken());
		}
		
		quick_sort(nums,0,nums.length-1);
		System.out.println(Arrays.toString(nums));
		System.out.println(nodes.get((int) (K-1)).i +" "+nodes.get((int) (K-1)).j);
	}
	
//	quick_sort(A[p..r]) { # A[p..r]을 오름차순 정렬한다.
//	    if (p < r) then {
//	        q <- partition(A, p, r);  # 분할
//	        quick_sort(A, p, q - 1);  # 왼쪽 부분 배열 정렬
//	        quick_sort(A, q + 1, r);  # 오른쪽 부분 배열 정렬
//	    }
//	}
	
	
	static void quick_sort(long[] arr, int p, int r) {
		if(p < r) {
			int q = partition(arr, p, r);
			quick_sort(arr, p, q-1);
			quick_sort(arr, q+1,r);
		}
	}


//	partition(A[], p, r) {
//	    x <- A[r];    # 기준원소
//	    i <- p - 1;   # i는 x보다 작거나 작은 원소들의 끝지점
//	    for j <- p to r - 1  # j는 아직 정해지지 않은 원소들의 시작 지점
//	        if (A[j] ≤ x) then A[++i] <-> A[j]; # i값 증가 후 A[i] <-> A[j] 교환
//	    if (i + 1 != r) then A[i + 1] <-> A[r]; # i + 1과 r이 서로 다르면 A[i + 1]과 A[r]을 교환
//	    return i + 1;
//	}
	
	static int partition(long[] arr, int p, int r) {
		long x = arr[r];
		int i = p-1;
		for(int j = p ; j < r ; j++) {
			if(arr[j] <= x) {
				i++;
				long temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				nodes.add(new node(i,j));
			}
		}
		if(i+1 != r) {
			long temp = arr[i+1];
			arr[i+1] = arr[r];
			arr[r] = temp;
			nodes.add(new node(i+1,r));
		}
		return i+1;
	}
}
class node {
	int i, j;

	public node(int i, int j) {
		super();
		this.i = i;
		this.j = j;
	}
	
	public node() {}
}

