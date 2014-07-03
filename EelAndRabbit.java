// Paste me into the FileEdit configuration dialog
// $METADATA$
public class EelAndRabbit {
   public int getmax(int[] l, int[] t) {
		// l 各うなぎの長さ
   		// t ウサギが各うなぎにたどり着く時間

   		// うなぎの頭の位置はt、尻尾の位置はt+l

   		int getCount = 0;
   		int repetition = 0;

   		for(int i = 0; i < l.length; i++){
   			for(int j = 0; j < l.length; j++){
				if(t[i] <= t[j] && t[i]+l[i] >= t[j]+l[j]) repetition++;
				else if(t[i] <= t[j] && t[i]+l[i] >= t[j]+l[j]) repetition++;
				else if(t[i] >= t[j] && t[i]+l[i] <= t[j]+l[j]) repetition++;
   			}
   		}
   		getCount = repetition;

   		return getCount;
   }

// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			EelAndRabbitHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				EelAndRabbitHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class EelAndRabbitHarness {
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

	static boolean compareOutput(int expected, int result) { return expected == result; }
	static String formatResult(int res) {
		return String.format("%d", res);
	}

	static int verifyCase(int casenum, int expected, int received) {
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
			int[] l                   = {2, 4, 3, 2, 2, 1, 10};
			int[] t                   = {2, 6, 3, 7, 0, 2, 0};
			int expected__            = 6;

			return verifyCase(casenum__, expected__, new EelAndRabbit().getmax(l, t));
		}
		case 1: {
			int[] l                   = {1, 1, 1};
			int[] t                   = {2, 0, 4};
			int expected__            = 2;

			return verifyCase(casenum__, expected__, new EelAndRabbit().getmax(l, t));
		}
		case 2: {
			int[] l                   = {1};
			int[] t                   = {1};
			int expected__            = 1;

			return verifyCase(casenum__, expected__, new EelAndRabbit().getmax(l, t));
		}
		case 3: {
			int[] l                   = {8, 2, 1, 10, 8, 6, 3, 1, 2, 5};
			int[] t                   = {17, 27, 26, 11, 1, 27, 23, 12, 11, 13};
			int expected__            = 7;

			return verifyCase(casenum__, expected__, new EelAndRabbit().getmax(l, t));
		}

		// custom cases

/*      case 4: {
			int[] l                   = ;
			int[] t                   = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new EelAndRabbit().getmax(l, t));
		}*/
/*      case 5: {
			int[] l                   = ;
			int[] t                   = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new EelAndRabbit().getmax(l, t));
		}*/
/*      case 6: {
			int[] l                   = ;
			int[] t                   = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new EelAndRabbit().getmax(l, t));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
