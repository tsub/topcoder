// Paste me into the FileEdit configuration dialog
// $METADATA$
public class SemiPerfectSquare {
   public String check(int N) {
		/*for(int b = 2; b < N; b++){
			// if(b*b*b == N){ // ３辺が等しい時
				// System.out.println("3hen" + b);
				// return "No";
			// }

			double n1 = (double)N / b;

			if(n1 == (int)n1){ // Nがbで割り切れた時のみこの後の判定をする
				// System.out.println(b);
				double n2 = (double)n1 / b;

				for(int a = 1; a < b; a++){
					if(n2 / a == 1){ // bで２回割った商がaで割り切れた時
						return "Yes";
					}
				}
			}
		}
		return "No";*/
		for(int b = 2; b < N; b++){
			for(int a = 1; a < b; a++){
				if(a*b*b == N) return "Yes";
				// else if(a < b) return "No";
			}
		}
		return "No";
   }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			SemiPerfectSquareHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				SemiPerfectSquareHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class SemiPerfectSquareHarness {
	public static void run_test(int casenum) {
		if (casenum != -1) {
			if (runTestCase(casenum) == -1)
				System.err.println("Illegal input! Test case " + casenum + " does not exist.");
			return;
		}

		int correct = 0, total = 0;
		for (int i=0;; ++i) {
			int x = runTestCase(i);
			if (x == -1) {
				if (i >= 100) break;
				continue;
			}
			correct += x;
			++total;
		}

		if (total == 0) {
			System.err.println("No test cases run.");
		} else if (correct < total) {
			System.err.println("Some cases FAILED (passed " + correct + " of " + total + ").");
		} else {
			System.err.println("All " + total + " tests passed!");
		}
	}

	static boolean compareOutput(String expected, String result) { return expected.equals(result); }
	static String formatResult(String res) {
		return String.format("\"%s\"", res);
	}

	static int verifyCase(int casenum, String expected, String received) {
		System.err.print("Example " + casenum + "... ");
		if (compareOutput(expected, received)) {
			System.err.println("PASSED");
			return 1;
		} else {
			System.err.println("FAILED");
			System.err.println("    Expected: " + formatResult(expected));
			System.err.println("    Received: " + formatResult(received));
			return 0;
		}
	}

	static int runTestCase(int casenum__) {
		switch(casenum__) {
		case 0: {
			int N                     = 48;
			String expected__         = "Yes";

			return verifyCase(casenum__, expected__, new SemiPerfectSquare().check(N));
		}
		case 1: {
			int N                     = 1000;
			String expected__         = "No";

			return verifyCase(casenum__, expected__, new SemiPerfectSquare().check(N));
		}
		case 2: {
			int N                     = 25;
			String expected__         = "Yes";

			return verifyCase(casenum__, expected__, new SemiPerfectSquare().check(N));
		}
		case 3: {
			int N                     = 47;
			String expected__         = "No";

			return verifyCase(casenum__, expected__, new SemiPerfectSquare().check(N));
		}
		case 4: {
			int N                     = 847;
			String expected__         = "Yes";

			return verifyCase(casenum__, expected__, new SemiPerfectSquare().check(N));
		}

		// custom cases
/*
      case 5: {
			int N                     = 512;
			String expected__         = "Yes";

			return verifyCase(casenum__, expected__, new SemiPerfectSquare().check(N));
		}*/
/*      case 6: {
			int N                     = 5;
			String expected__         = No;

			return verifyCase(casenum__, expected__, new SemiPerfectSquare().check(N));
		}*/
/*      case 7: {
			int N                     = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new SemiPerfectSquare().check(N));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
