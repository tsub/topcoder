public class GCD {
	public int gcd(int x, int y) {
		/*if(x < y){
			int temp = y;
			y = x;
			x = temp;
		}*/
		while(true){
			int r = x % y;
			if(r == 0){
				break;
			}/*else if(r > y){
				break;
			}*/
			x = y;
			y = r;
		}
		return y;
	}
// 728 % 693 = 35
// 693 % 35 = 28
// 35 % 28 = 7
// 28 % 7 = 0

	public static void main(String[] args) {
		int[][] result = { { 3, 2, 1 }, { 10, 5, 5 }, { 4, 3, 1 },
				{ 3, 10, 1 }, { 12, 18, 6 }, { 693, 728, 7 } };
		for (int i = 0; i < result.length; i++) {
			System.err.print("Test case " + i + " ");
			int r = new GCD().gcd(result[i][0], result[i][1]);
			if (r == result[i][2]) {
				System.err.println("passed");
			} else {
				System.err.println("not passed");
				System.err.println("\t expected " + result[i][2]);
				System.err.println("\t result " + r);

			}
		}
	}
}
