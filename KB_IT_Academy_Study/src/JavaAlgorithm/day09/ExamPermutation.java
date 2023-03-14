package JavaAlgorithm.day09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;

public class ExamPermutation {
	private static int n, m;
	private static char[] arr; // 원소를 저장할 배
	private static ArrayList<char[]> ansList = new ArrayList<>();
	private static boolean[] visited; // 중복을 제거하기 위한 방문 처리

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<Integer>arr1 = new ArrayList<Integer>();
		arr1.add(1);
		arr1.add(2);
		arr1.add(3);
//		getPermutation(arr);
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        char[] arr2 = str.toCharArray();
        int num = Integer.parseInt(st.nextToken());
        System.out.println(arr2);
        arr = new char[arr2.length];
        visited = new boolean[arr2.length + 1];
        n = arr2.length-1;
        m = arr2.length-1;
        permutation(0, arr2);
	}

	private static int getPermutation(ArrayList<Integer> arr) {
		for(int i = 0; i<arr.size();i++) {
			ArrayList<Integer> temp = new ArrayList<>(arr);
			temp.add(0,temp.remove(i));
			for(int j = 1; j < arr.size();j++) {
				System.out.println(temp.toString());
				temp.add(temp.remove(j));
			}
		}
		return 0;
	}
	
	private static void permutation(int cnt, char[] arr2) {
        if (cnt == m) {
        	arr[cnt] = arr2[m];
            System.out.println(Arrays.toString(arr));
            ansList.add(arr);
            return;
        }
        for (int i = 0; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[cnt] = arr2[i];
                permutation(cnt + 1, arr2);
                visited[i] = false; // 다시 방문을 풀어줘야지만 한 번 재귀 끝나고 다시 갈 수 있음
            }
        }
    }
}
