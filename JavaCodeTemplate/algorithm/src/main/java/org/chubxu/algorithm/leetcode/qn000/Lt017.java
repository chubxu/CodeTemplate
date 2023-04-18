package org.chubxu.algorithm.leetcode.qn000;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Lt017 {
    List<String> res = new ArrayList<>();
    Map<Character, char[]> map = Map.of(
            '2', new char[]{'a', 'b', 'c'},
            '3', new char[]{'d', 'e', 'f'},
            '4', new char[]{'g', 'h', 'i'},
            '5', new char[]{'j', 'k', 'l'},
            '6', new char[]{'m', 'n', 'o'},
            '7', new char[]{'p', 'q', 'r', 's'},
            '8', new char[]{'t', 'u', 'v'},
            '9', new char[]{'w', 'x', 'y', 'z'}
    );
    public List<String> letterCombinations(String digits) {
        char[] charArray = digits.toCharArray();
        if (charArray.length != 0) {
            backTrace(charArray, new StringBuilder(), 0);
        }
        return res;
    }

    public void backTrace(char[] charArray, StringBuilder curStringBuilder, int i) {
        if (charArray.length == i) {
            res.add(curStringBuilder.toString());
            return;
        }
        char[] chars = map.get(charArray[i]);
        for (char aChar : chars) {
            curStringBuilder.append(aChar);
            backTrace(charArray, curStringBuilder, i+1);
            curStringBuilder.deleteCharAt(curStringBuilder.length()-1);
        }
    }

    public static void main(String[] args) {
        Lt017 lt017 = new Lt017();
        System.out.println(lt017.letterCombinations("23"));
    }
}
