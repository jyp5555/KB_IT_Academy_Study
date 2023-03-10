package JavaAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class workbook {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long n = Long.parseLong(st.nextToken());
		int pivot = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> numArr = new ArrayList<>();
		HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();
		numArr.add(0);
		
		for(int i = 0;i < pivot;i++) {
			hashMap.put(i, new ArrayList<Integer>());
		}
		hashMap.get(0).add(0);
		System.out.println(hashMap.toString());
		st = new StringTokenizer(br.readLine());
		
		for(int i = 1;i<n+1;i++) {
			numArr.add(numArr.get(i-1)+Integer.parseInt(st.nextToken()));
			hashMap.get(numArr.get(i)%pivot).add(numArr.get(i));
		}
				
		long ans = 0;
		for(int i = 0;i<hashMap.size();i++) {
			int m = hashMap.get(i).size();
			ans+=(long)m*(m-1)/2;
		}
		
		System.out.println(ans);
	}
}
