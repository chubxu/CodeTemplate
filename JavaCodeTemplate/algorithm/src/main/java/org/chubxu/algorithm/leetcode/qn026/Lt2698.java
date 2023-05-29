package org.chubxu.algorithm.leetcode.qn026;

public class Lt2698 {
    private static final int[] PRE_SUM = new int[1001];

    static {
        for (int i = 1; i <= 1000; i++) {
            var s = Integer.toString(i * i).toCharArray();
            PRE_SUM[i] = PRE_SUM[i - 1] + (dfs(s, i, 0, 0) ? i * i : 0);
        }
    }

    public int punishmentNumber(int n) {
        return PRE_SUM[n];
    }

    public static boolean dfs(char[] cs, int num, int index, int sum) {
        if (index == cs.length) {
            return sum == num;
        }
        int x = 0;
        for (int j = index; j<cs.length; j++) {
            x = x * 10 + cs[j] - '0';
            if (dfs(cs, num, j+1, sum + x)) {
                return true;
            }
        }
        return false;
    }
}
