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
	private static int[] arr; // 원소를 저장할 배
	private static ArrayList<char[]> ansList = new ArrayList<>();
	private static boolean[] visited; // 중복을 제거하기 위한 방문 처리

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<Integer>arr1 = new ArrayList<Integer>();
		arr1.add(1);
		arr1.add(2);
		arr1.add(3);
//		getPermutation(arr);

        
        arr = new int[3];
        visited = new boolean[arr.length + 1];
        n = arr.length-1;
        m = arr.length-1;
        permutation(0);
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
	
	private static void permutation(int cnt) {
        //종료조건검사
        if (cnt == m) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        //로직처리
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[cnt] = i;
                // 같은메서드 호출
                permutation(cnt + 1);
                visited[i] = false;
            }
        }
    }
}
