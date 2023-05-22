package org.chubxu.algorithm.leetcode.qn025;

import java.util.LinkedList;

public class Lt2526 {
}

class DataStream {

    LinkedList<Integer> queue;
    LinkedList<Integer> notEqualQueue;
    int v;
    int k;

    public DataStream(int value, int k) {
        queue = new LinkedList<>();
        notEqualQueue = new LinkedList<>();
        v = value;
        this.k = k;
    }

    public boolean consec(int num) {
        if (queue.size() == k) {
            int tmp = queue.pollFirst();
            if (notEqualQueue.size() > 0 && tmp == notEqualQueue.peek()) {
                notEqualQueue.pollFirst();
            }
        }
        if (num != v) notEqualQueue.addLast(num);
        queue.addLast(num);
        if (queue.size() != k) return false;

        return notEqualQueue.isEmpty();
    }
}

class DataStream2 {

    int cnt;
    int v;
    int k;

    public DataStream2(int value, int k) {
        v = value;
        this.k = k;
        this.cnt = 0;
    }

    public boolean consec(int num) {
        if (num == v) cnt++;
        else cnt = 0;
        return cnt >= k;
    }
}
