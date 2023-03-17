package JavaAlgorithm.day09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 백준_B9742_순열_박진영2 {
	
	static ArrayList<Boolean> visited = new ArrayList<>();
	static ArrayList<String> permutationResultList;
	static char[] permutationResult;
	static ArrayList<String> answerList = new ArrayList<>();
	static int n,r;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str,str1;
		while((str = br.readLine()) != null) {
			if(str.isBlank() || str.isEmpty())break;
			StringTokenizer st = new StringTokenizer(str);
			String permutationInput = st.nextToken().strip();
			char[] permutationTarget = new char[permutationInput.length()];
			if(permutationInput.isBlank() || permutationInput.isEmpty()) break;
			else {
				for(int i = 0; i < permutationInput.length() ; i++) {
					permutationTarget[i] =permutationInput.toString().charAt(i);
					visited.add(false);
				}
			}
			int count = Integer.parseInt(st.nextToken());
			
			n = permutationTarget.length-1;
			r = permutationTarget.length-1;
			permutationResultList = new ArrayList<>();
			permutationResult = new char[permutationTarget.length];
			permute(0, permutationTarget);
			if(count > permutationResultList.size() || count == 0) {
				str1 = "No permutation";
			}else {
				str1 = permutationResultList.get(count-1).toString();
			}
			answerList.add(permutationInput+" "+count+ " = "+str1);
		}
		
		for (String i : answerList) {
			System.out.println(i);
		}
	}

	private static void permute(int cnt, char[] target) {
		if(cnt == r) {
			permutationResult[r] = target[visited.indexOf(false)];
			permutationResultList.add(String.valueOf(permutationResult));
			return;
		}
		for(int i = 0 ; i < target.length ; i++) {
			if(!visited.get(i)) {
				visited.set(i, true);
				permutationResult[cnt] = target[i];
				permute(cnt+1,target);
				visited.set(i,false);
			}
		}	
	}
}
