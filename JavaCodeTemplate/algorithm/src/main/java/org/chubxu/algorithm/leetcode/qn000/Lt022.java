package org.chubxu.algorithm.leetcode.qn000;

import java.util.ArrayList;
import java.util.List;

public class Lt022 {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return res;
        }
        dfs("", n, n);
        return res;
    }

    public void dfs(String str, int l, int r) {
        if (l == 0 && r == 0) {
            res.add(str);
            return;
        }
        if (l == r) {
            dfs(str+"(", l-1, r);
        } else if (l < r) {
            if (l > 0) {
                dfs(str+"(", l-1, r);
            }
            dfs(str+")", l, r-1);
        }
    }
}
