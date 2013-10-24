// Paste me into the FileEdit configuration dialog
// $METADATA$
public class SpiralWalking {
   public int totalPoints(String[] levelMap) {
   	int[] copyMap = new int[levelMap.length()];
   	for(int i = 0; i < levelMap.length(); i++){
   		copyMap[i] = Integer.parseInt(levelMap.charAt[i]);
   		System.out.println(copyMap[i]);
   	}
   	/*
   	int x = 0, y = 0;
   	int total = 0;
   	int[] position = {x, y};
	for(int i = 0; i < (int)levelMap.length; i++){
		for(int j = 0; j < (int)levelMap[i].length(); j++){
			y++;
			if(j == (int)levelMap[i].length() - 1){
				total += (int)levelMap.charAt(j + 1);
			}
		}
		x++;
		if(i == (int)levelMap.length() - 1){
			total += (int)levelMap.charAt(i + 1);
		}
	}*/
/*
	for(int i = 0; i < levelMap.length; i--){
		for(int j = 0; j < levelMap[i].length(); j--){
			y++;
			if(j == levelMap[i].length - 1){
				total += Integer.parseInt(levelMap.charAt(j));
			}
		}
		x++;
	}*/
	return 1;
}


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			SpiralWalkingHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				SpiralWalkingHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class SpiralWalkingHarness {
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
			String[] levelMap         = {"111",
 "111",
 "111"};
			int expected__            = 5;

			return verifyCase(casenum__, expected__, new SpiralWalking().totalPoints(levelMap));
		}
		case 1: {
			String[] levelMap         = {"101",
 "110"};
			int expected__            = 3;

			return verifyCase(casenum__, expected__, new SpiralWalking().totalPoints(levelMap));
		}
		case 2: {
			String[] levelMap         = {"00",
 "10"};
			int expected__            = 1;

			return verifyCase(casenum__, expected__, new SpiralWalking().totalPoints(levelMap));
		}
		case 3: {
			String[] levelMap         = {"86850",
 "76439",
 "15863",
 "24568",
 "45679",
 "71452",
 "05483"};
			int expected__            = 142;

			return verifyCase(casenum__, expected__, new SpiralWalking().totalPoints(levelMap));
		}

		// custom cases

/*      case 4: {
			String[] levelMap         = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new SpiralWalking().totalPoints(levelMap));
		}*/
/*      case 5: {
			String[] levelMap         = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new SpiralWalking().totalPoints(levelMap));
		}*/
/*      case 6: {
			String[] levelMap         = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new SpiralWalking().totalPoints(levelMap));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
