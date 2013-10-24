// Paste me into the FileEdit configuration dialog
// $METADATA$
public class SurveillanceSystem {
   public String getContainerInfo(String containers, int[] reports, int L) {
		// 自分は泥棒で、倉庫に入ろうとしている
		// カメラはどこにあるか分からない
		// containersは倉庫がある場所
		// reportsはそれぞれの隠しカメラが監視している倉庫の数
		// Lは隠しカメラが撮すことのできる倉庫の数

		// 確実に映る場所は+,カメラの配置によって写るかもしれない場所は?,カメラに写らない場所は-
		// 全ての倉庫の位置において写るどうかを配列で返す


   		// カメラが撮している倉庫の数を{3, 0, 2, 0}なら{3:1, 0:2, 2:1}のように変換
   		// 全ての場所において撮されている隠しカメラの数を数える
   		// -?+の判定
   		// 撮されている数が0のところは-

   		int containerCount = 0;
   		int[] reported = new int[containers.length()];
   		String ans = new String[containers.length()];

   		for(int i = 0; i < reported.length; i++){
   			reported[i] = 0;
   		}

   		for(int i = 0; i < reports.length; i++){
   			for(int j = reports[i]; j < reports[i]+L; j++){
   				if(containers.charAt(j) == 'X' && containerCount < reports[i]){
   					containerCount++;
   				}
   			}
   			if(containerCount == reports[i]){
   				reported[i]++;
   			}
   			containerCount = 0;
   		}

   		return ans;
   }

// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			SurveillanceSystemHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				SurveillanceSystemHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class SurveillanceSystemHarness {
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
			String containers         = "-X--XX";
			int[] reports             = {1, 2};
			int L                     = 3;
			String expected__         = "??++++";

			return verifyCase(casenum__, expected__, new SurveillanceSystem().getContainerInfo(containers, reports, L));
		}
		case 1: {
			String containers         = "-XXXXX-";
			int[] reports             = {2};
			int L                     = 3;
			String expected__         = "???-???";

			return verifyCase(casenum__, expected__, new SurveillanceSystem().getContainerInfo(containers, reports, L));
		}
		case 2: {
			String containers         = "------X-XX-";
			int[] reports             = {3, 0, 2, 0};
			int L                     = 5;
			String expected__         = "++++++++++?";

			return verifyCase(casenum__, expected__, new SurveillanceSystem().getContainerInfo(containers, reports, L));
		}
		case 3: {
			String containers         = "-XXXXX---X--";
			int[] reports             = {2, 1, 0, 1};
			int L                     = 3;
			String expected__         = "???-??++++??";

			return verifyCase(casenum__, expected__, new SurveillanceSystem().getContainerInfo(containers, reports, L));
		}
		case 4: {
			String containers         = "-XX--X-XX-X-X--X---XX-X---XXXX-----X";
			int[] reports             = {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
			int L                     = 7;
			String expected__         = "???++++?++++++++++++++++++++??????--";

			return verifyCase(casenum__, expected__, new SurveillanceSystem().getContainerInfo(containers, reports, L));
		}

		// custom cases

/*      case 5: {
			String containers         = ;
			int[] reports             = ;
			int L                     = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new SurveillanceSystem().getContainerInfo(containers, reports, L));
		}*/
/*      case 6: {
			String containers         = ;
			int[] reports             = ;
			int L                     = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new SurveillanceSystem().getContainerInfo(containers, reports, L));
		}*/
/*      case 7: {
			String containers         = ;
			int[] reports             = ;
			int L                     = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new SurveillanceSystem().getContainerInfo(containers, reports, L));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
