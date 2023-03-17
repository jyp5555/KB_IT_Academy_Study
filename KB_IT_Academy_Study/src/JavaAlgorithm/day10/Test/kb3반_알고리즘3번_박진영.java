package JavaAlgorithm.day10.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class kb3반_알고리즘3번_박진영 {
	static int[][] board;
	static final int E = 0;
	static final int SE = 1;
	static final int S = 2;
	static final int SW = 3;
	static boolean[][] visited;
	static ArrayList<Integer> resultList1;
	static ArrayList<Integer> resultList2;
	public static void main(String[] args) throws IOException {
		System.out.println(E==0);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new int[21][21]; //21,21
		visited = new boolean[7][7];
		System.out.println(Arrays.toString(visited[0]));
		for(int i = 1; i <= 19 ; i++) { //19
			StringTokenizer st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				for(int j = 1; j <= 19 ; j++) {//19
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		int black = 0;int k = 0; int m = 0; int result = 0;
		while(true) {
			if( k==6 || m == 6) break;
			for(k = 1; k <= 5; k++) {
				for(m = 1; m <= 5 ; m++) {
					if(board[k][m] == 1 && !(visited[k][m])) {
						visited[k][m] = true;
						resultList1 = new ArrayList<>();
						for(int i  = 0; i < 3;i++) {
							
							findBlackStone(1,i,k,m);
						}
						if(resultList1.contains(5)) {black = 1; break;}
						visited[k][m] = false;
					}
				}
			}
		}
		int white = 0;int b = 0; int q = 0; int result2 = 0;
		while(true) {
			if( b==6 || q == 6) break;
			for(b = 1; b <= 5; b++) {
				for(q = 1; q <= 5 ; q++) {
					if(board[b][q] == 1 && !(visited[b][q])) {
						visited[b][q] = true;
						resultList2 = new ArrayList<>();
						for(int i  = 0; i < 3;i++) {
							
							findBlackStone(1,i,b,q);
						}
						if(resultList2.contains(5)) {white = 2; break;}
						visited[b][q] = false;
					}
				}
			}
		}
		
		if(black ==1 && white ==0) System.out.println(1);
		else if(black ==0 && white ==2) System.out.println(2);
		else System.out.println(0);
	}

	private static int findBlackStone(int cnt,int direction, int orX, int orY) {
		if(cnt >= 5) {resultList2.add( cnt); return cnt;}
		else {
			switch(direction) {
				case E:
					if(board[orX][orY+1] == 1) return findBlackStone(cnt+1, E, orX, orY+1);
					else return cnt;
				case SE:
					if(board[orX+1][orY+1] == 1) return findBlackStone(cnt+1, SE, orX+1, orY+1);
					else return cnt;

				case S:
					if(board[orX+1][orY] == 1) return findBlackStone(cnt+1, S, orX+1, orY);
					else return cnt;

				case SW:
					if(board[orX+1][orY-1] == 1) return findBlackStone(cnt+1, SW, orX+1, orY-1);
					else return cnt;

				default:
					return cnt;
			}
			

		}		
	}
	private static int findWhiteStone(int cnt,int direction, int orX, int orY) {
		if(cnt >= 5) {resultList2.add( cnt); return cnt;}
		else {
			switch(direction) {
				case E:
					if(board[orX][orY+1] == 2) return findBlackStone(cnt+1, E, orX, orY+1);
					else return cnt;
				case SE:
					if(board[orX+1][orY+1] == 2) return findBlackStone(cnt+1, SE, orX+1, orY+1);
					else return cnt;

				case S:
					if(board[orX+1][orY] == 2) return findBlackStone(cnt+1, S, orX+1, orY);
					else return cnt;

				case SW:
					if(board[orX+1][orY-1] == 2) return findBlackStone(cnt+1, SW, orX+1, orY-1);
					else return cnt;

				default:
					return cnt;
			}
			

		}		
	}
}
