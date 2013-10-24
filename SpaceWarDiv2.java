// Paste me into the FileEdit configuration dialog
// $METADATA$
public class SpaceWarDiv2 {
   public int minimalFatigue(int[] magicalGirlStrength, int[] enemyStrength, int[] enemyCount) {
		int minFatigue = 0;

		while(true){
			for(int i = 0; i < magicalGirlStrength.length; i++){
				// 敵の数がいなくなったら倒さない
				int isWin = 0;
				for(int j = 0; j < enemyCount.length; j++){
					if(enemyCount[j] == 0) isWin++;
				}
				if(isWin != enemyCount.length){
					// iの魔法少女が敵に勝てるかどうかの判定
					int isLoss = 0;
					for(int j = 0; j < enemyCount.length; j++){
						if(magicalGirlStrength[i] < enemyStrength[j]) isLoss++;
					}
					if(isLoss == enemyCount.length) continue;

					// iの魔法少女より弱い中で一番強い敵(標的)を決める
					int target = enemyStrength[0];
					for(int j = 0; j < enemyCount.length; j++){
						if(enemyCount[j] == 0) continue;
						if(enemyStrength[j] > target && magicalGirlStrength[i] >= enemyStrength[j]){
							target = enemyStrength[j];
						}
					}
					System.out.println("target's strength is " + target);
					for(int j = 0; j < enemyCount.length; j++){
						if(target == enemyStrength[j]){
							target = j;
							System.out.println("target's num is " + target);
							break;
						}
					}

					// 敵を倒す(敵の数を１減らす)
					System.out.println(i + " MagicalGirl kill to " + target + " Enemy");
					enemyCount[target]--;
				}
				/*
				// iの魔法少女が敵に勝てるかどうかの判定
				int isLoss = 0;
				for(int j = 0; j < enemyCount.length; j++){
					if(magicalGirlStrength[i] < enemyStrength[j]) isLoss++;
				}
				if(isLoss == enemyCount.length) continue;

				// iの魔法少女より弱い中で一番強い敵(標的)を決める
				int target = enemyStrength[0];
				for(int j = 0; j < enemyCount.length; j++){
					if(enemyCount[j] == 0) continue;
					if(enemyStrength[j] > target && magicalGirlStrength[i] >= enemyStrength[j]){
						target = enemyStrength[j];
					}
				}
				System.out.println("target's strength is " + target);
				for(int j = 0; j < enemyCount.length; j++){
					if(target == enemyStrength[j]){
						target = j;
						System.out.println("target's num is " + target);
						break;
					}
				}

				// 敵を倒す(敵の数を１減らす)
				System.out.println(i + " MagicalGirl kill to " + target + " Enemy");
				enemyCount[target]--;*/
			}

			// ターン終了
			minFatigue++;

			// 敵全員に勝てなかったら終了
			int isDefeat = 0;
			for(int i = 0; i < enemyCount.length; i++){
				if(magicalGirlStrength[i] < enemyStrength[i]) isDefeat++;
			}
			if(isDefeat == enemyCount.length){
				minFatigue = -1;
				break;
			}

			// 敵を倒しきったら終了
			int isVictory = 0;
			for(int i = 0; i < enemyCount.length; i++){
				if(enemyCount[i] == 0) isVictory++;
			}
			if(isVictory == enemyCount.length) break;

			if(minFatigue == 10) break;
		}

		return minFatigue;
   }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			SpaceWarDiv2Harness.run_test(0);
		} else {
			for (int i=0; i<args.length; ++i)
				SpaceWarDiv2Harness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE
}

// BEGIN CUT HERE
class SpaceWarDiv2Harness {
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
			int[] magicalGirlStrength = {2, 3, 5};
			int[] enemyStrength       = {1, 3, 4};
			int[] enemyCount          = {2, 9, 4};
			int expected__            = 7;

			return verifyCase(casenum__, expected__, new SpaceWarDiv2().minimalFatigue(magicalGirlStrength, enemyStrength, enemyCount));
		}
		case 1: {
			int[] magicalGirlStrength = {2, 3, 5};
			int[] enemyStrength       = {1, 1, 2};
			int[] enemyCount          = {2, 9, 4};
			int expected__            = 5;

			return verifyCase(casenum__, expected__, new SpaceWarDiv2().minimalFatigue(magicalGirlStrength, enemyStrength, enemyCount));
		}
		case 2: {
			int[] magicalGirlStrength = {14, 6, 22};
			int[] enemyStrength       = {8, 33};
			int[] enemyCount          = {9, 1};
			int expected__            = -1;

			return verifyCase(casenum__, expected__, new SpaceWarDiv2().minimalFatigue(magicalGirlStrength, enemyStrength, enemyCount));
		}
		case 3: {
			int[] magicalGirlStrength = {17, 10, 29, 48, 92, 60, 80, 100, 15, 69, 36, 43, 70, 14, 88, 12, 14, 29, 9, 40};
			int[] enemyStrength       = {93, 59, 27, 68, 48, 82, 15, 95, 61, 49, 68, 15, 16, 26, 64, 82, 7, 8, 92, 15};
			int[] enemyCount          = {56, 26, 12, 52, 5, 19, 93, 36, 69, 61, 68, 66, 55, 28, 49, 55, 63, 57, 33, 45};
			int expected__            = 92;

			return verifyCase(casenum__, expected__, new SpaceWarDiv2().minimalFatigue(magicalGirlStrength, enemyStrength, enemyCount));
		}

		// custom cases

/*      case 4: {
			int[] magicalGirlStrength = ;
			int[] enemyStrength       = ;
			int[] enemyCount          = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new SpaceWarDiv2().minimalFatigue(magicalGirlStrength, enemyStrength, enemyCount));
		}*/
/*      case 5: {
			int[] magicalGirlStrength = ;
			int[] enemyStrength       = ;
			int[] enemyCount          = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new SpaceWarDiv2().minimalFatigue(magicalGirlStrength, enemyStrength, enemyCount));
		}*/
/*      case 6: {
			int[] magicalGirlStrength = ;
			int[] enemyStrength       = ;
			int[] enemyCount          = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new SpaceWarDiv2().minimalFatigue(magicalGirlStrength, enemyStrength, enemyCount));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
