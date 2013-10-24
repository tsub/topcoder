// Paste me into the FileEdit configuration dialog
// $METADATA$
public class IDNumberVerification {
   public String verify(String id, String[] regionCodes) {
		
   }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			IDNumberVerificationHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				IDNumberVerificationHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class IDNumberVerificationHarness {
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
			String id                 = "441323200312060636";
			String[] regionCodes      = {"441323"};
			String expected__         = "Male";

			return verifyCase(casenum__, expected__, new IDNumberVerification().verify(id, regionCodes));
		}
		case 1: {
			String id                 = "62012319240507058X";
			String[] regionCodes      = {"620123"};
			String expected__         = "Female";

			return verifyCase(casenum__, expected__, new IDNumberVerification().verify(id, regionCodes));
		}
		case 2: {
			String id                 = "321669197204300886";
			String[] regionCodes      = {"610111","659004"};
			String expected__         = "Invalid";

			return verifyCase(casenum__, expected__, new IDNumberVerification().verify(id, regionCodes));
		}
		case 3: {
			String id                 = "230231198306900162";
			String[] regionCodes      = {"230231"};
			String expected__         = "Invalid";

			return verifyCase(casenum__, expected__, new IDNumberVerification().verify(id, regionCodes));
		}
		case 4: {
			String id                 = "341400198407260005";
			String[] regionCodes      = {"341400"};
			String expected__         = "Invalid";

			return verifyCase(casenum__, expected__, new IDNumberVerification().verify(id, regionCodes));
		}
		case 5: {
			String id                 = "520381193206090891";
			String[] regionCodes      = {"532922","520381"};
			String expected__         = "Invalid";

			return verifyCase(casenum__, expected__, new IDNumberVerification().verify(id, regionCodes));
		}

		// custom cases

/*      case 6: {
			String id                 = ;
			String[] regionCodes      = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new IDNumberVerification().verify(id, regionCodes));
		}*/
/*      case 7: {
			String id                 = ;
			String[] regionCodes      = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new IDNumberVerification().verify(id, regionCodes));
		}*/
/*      case 8: {
			String id                 = ;
			String[] regionCodes      = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new IDNumberVerification().verify(id, regionCodes));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
