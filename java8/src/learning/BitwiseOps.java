package learning;

public class BitwiseOps {
	public static void main(String[] args) {

//		int x =  1 & 5;
//
//		long start = System.currentTimeMillis();
//
//		int result = rangeBitwiseAnd(1, 2147483647);
//		System.out.println("cxt is " + Integer.toString(cxt));
//
//		long finish = System.currentTimeMillis();
//		long timeElapsed = finish - start;
//		System.out.println(timeElapsed);
//		System.out.println(result);
//
//
//		start = System.currentTimeMillis();
//
//		result = rangeBitwiseAnd3(1, 2147483647);
//
//		finish = System.currentTimeMillis();
//		timeElapsed = finish - start;
//		System.out.println(timeElapsed);
//		System.out.println(result);
		int m = -5;

		int x = -5/2;
		System.out.println(m << 1);
		System.out.println(x);
	}

	public static int cxt = 0;

	public static int rangeBitwiseAnd(int m, int n) {
		cxt += 1;
		if (m == 0) {
			return 0;
		}
		if (n - m == 1) {
			return n & m;
		}

		if (n == m) {
			return m;
		}

		int mid = m + (n-m)/2;

		return rangeBitwiseAnd(m, mid) & rangeBitwiseAnd(mid + 1, n);
	}

	public static int rangeBitwiseAnd3(int m, int n) {
		if(m == 0){
			return 0;
		}
		int moveFactor = 1;
		int cnt = 0;
		while(m != n){
			cnt += 1;
			m >>= 1;
			n >>= 1;
			moveFactor <<= 1;
		}
		System.out.println("cnt is " + Integer.toString(cnt));
		return m * moveFactor;
	}

//	public static int rangeBitwiseAnd2(int m, int n) {
//		if (m == 0) {
//			return 0;
//		}
//		int result = m;
//		for (int i = m; i <= n; i++) {
//			result = result & i;
////			System.out.println(result);
//		}
//		return result;
//	}
}
