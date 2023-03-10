package JavaAlgorithm.day07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 백준_B12891_DNA비밀번호 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int count = Integer.parseInt(st.nextToken());
		int pwdLength = Integer.parseInt(st.nextToken());
		int startIndex = 0;
		int endIndex = pwdLength -1;
		int ans = 0;

		
		String pwdCandidate = br.readLine();
		ArrayList<Integer> condition = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<4;i++) {
			condition.add(Integer.parseInt(st.nextToken()));
		}
		int A = 0;
		int C = 0;
		int G = 0;
		int T = 0;
		for (int i = 0; i< pwdLength;i++) {
			switch(pwdCandidate.charAt(i)) {
			case 'A':
				A++;
				break;
			case 'C':
				C++;
				break;
			case 'G':
				G++;
				break;
			case 'T':
				T++;
				break;
			default:
				break;
			}
		}
		
		for (int i = 0 ; i+pwdLength <= pwdCandidate.length() ; i++) {
			if(A >= condition.get(0)&&C >= condition.get(1)&&G >= condition.get(2)&&T >= condition.get(3)) ans++;
			if(i+pwdLength == pwdCandidate.length()) break;

			switch(pwdCandidate.charAt(i)) {
				case 'A':
					A--;
					break;
				case 'C':
					C--;
					break;
				case 'G':
					G--;
					break;
				case 'T':
					T--;
					break;
				default:
					System.out.println(pwdCandidate.charAt(i));
					break;
			}
			switch(pwdCandidate.charAt(i+pwdLength)){
				case 'A':
					A++;
					break;
				case 'C':
					C++;
					break;
				case 'G':
					G++;
					break;
				case 'T':
					T++;
					break;
				default:
					System.out.println(pwdCandidate.charAt(i+pwdLength-1));
					break;
			}
			
		}
		
		System.out.println(ans);
	}
}
