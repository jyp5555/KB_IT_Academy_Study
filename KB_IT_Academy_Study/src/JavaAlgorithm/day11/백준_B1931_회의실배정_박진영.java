package JavaAlgorithm.day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 백준_B1931_회의실배정_박진영 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		ArrayList<MeetingTime> meetTimes = new ArrayList<>();
		ArrayList<Integer> answerList = new ArrayList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine().strip());
		for(int i = 0; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			MeetingTime m = new MeetingTime(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			meetTimes.add(m);
		}
		
		Collections.sort(meetTimes);
		
		
		for(int i = 0 ; i < N ; i++) {
			if(i == 0) {
				answerList.add(i);
			}
			else {
				if(meetTimes.get(i).start >= meetTimes.get(answerList.get(answerList.size()-1)).end) {
					answerList.add(i);
				}
			}
		}
		System.out.println(answerList.size());
	}
}
class MeetingTime implements Comparable<MeetingTime>{
	int start;
	int end;
	
	public MeetingTime(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}
	
	@Override
	public String toString() {
		return "start=" + start + ", end=" + end;
	}

	@Override
	public int compareTo(MeetingTime o) {
		if(this.end == o.end) {
			return this.start - o.start;
		}
		return this.end - o.end;
	}
}