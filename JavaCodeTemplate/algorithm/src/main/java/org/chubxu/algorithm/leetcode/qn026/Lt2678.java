package org.chubxu.algorithm.leetcode.qn026;

public class Lt2678 {
    public int countSeniors(String[] details) {
        int num = 0;
        for(String detail:details){
            int age = (detail.charAt(11) - '0') * 10 +(detail.charAt(12) - '0');
            if(age > 60){
                num++;
            }
        }
        return num;
    }
}
