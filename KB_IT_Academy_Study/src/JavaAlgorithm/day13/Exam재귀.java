package JavaAlgorithm.day13;

public class Exam재귀 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = sumRecursive(1,5);
		System.out.println(sum);
		int sum2 = sumRecursive(5);
		System.out.println(sum2);

		int sum3 = sumRecursive(10);
		System.out.println(sum3);
		
//		int sum4 = sumRecursive4(10, 2, 0);
		int sum4 = sumRecursive4(10, 2, 1);

		System.out.println(sum3);

	}

	private static int sumRecursive4(int i, int j, int flag) {
		if(i<j) {
			return 0;
		}
		else if(flag == 0) {
			if(i % 2 == 0) {return i + sumRecursive4(i-1,j,flag);}
			return sumRecursive4(i-1,j,flag);
		}else if(flag == 1) {
			if(i%2 != 0)return i + sumRecursive4(i-1,j,flag);
		}
		System.out.println(i);
		return sumRecursive4(i-1,j,flag);
	}

	private static int sumRecursive(int i, int j) {
		if(i == j) {
			return i;
		}
		return j + sumRecursive(i,j-1);
	}

	private static int sumRecursive(int i) {
		if(i == 0) return 0;
		else if (i % 2 == 0) return i + sumRecursive(i-1);
		return sumRecursive(i-1);
	}

}
