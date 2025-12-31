/** Computes the binomial(n,k) function. */
public class Binomial {	
    public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int k = Integer.parseInt(args[1]);
		System.out.println(binomial(n, k));
	}

	// Computes the Binomial function, basic version.
	public static int binomial1(int n, int k) { 
		if(k > n) return 0;
		if(k == 0 || n == 0) return 1;
		return binomial1(n - 1, k) + binomial1(n - 1, k - 1);
	 } 
	
	// Computes the Binomial function, efficiently
	public static long binomial(int n, int k) {
		if(k > n) return 0;
		if(k == 0 || n == 0) return 1;
		
		long [][] memo = new long[n + 1][k + 1];
		for(int i = 0; i <= n; i ++) {
			for(int j = 0; j <= k; j ++) {
				memo[i][j] = -1;
			}
		}
		return binomial(n, k, memo);
	}

	private static long binomial(int n, int k, long[][] memo) {
		
		if (k > n) return 0;
		if (k == 0 || n == k) return 1;
		
		if(memo[n][k] != -1) {
			return memo[n][k];
		}

		memo[n][k] = binomial( n - 1, k, memo) + binomial(n - 1, k - 1, memo);
		return memo[n][k];
	}
}



