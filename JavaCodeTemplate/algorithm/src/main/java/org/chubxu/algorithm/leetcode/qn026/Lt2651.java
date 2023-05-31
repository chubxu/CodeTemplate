package org.chubxu.algorithm.leetcode.qn026;

public class Lt2651 {
    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime + delayedTime) % 24;
    }
}
