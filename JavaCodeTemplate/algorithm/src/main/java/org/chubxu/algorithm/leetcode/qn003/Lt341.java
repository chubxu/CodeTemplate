package org.chubxu.algorithm.leetcode.qn003;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Lt341 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ReentrantLock lock = new ReentrantLock();
        long i = 0;
        for (long j = 0; j<5_0000_0000L; j++) {
            lock.lock();
            i++;
            lock.unlock();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
class NestedIterator implements Iterator<Integer> {
    List<Integer> list;
    Iterator<Integer> it;

    public NestedIterator(List<NestedIterator> nestedList) {
        list = new ArrayList<>();
        dfs(nestedList);
        it = list.iterator();
    }

    @Override
    public Integer next() {
        return it.next();
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }

    public void dfs(List<NestedIterator> list) {
        // for (NestedIterator nestedIterator : list) {
        //     if (nestedIterator.isInteget()) {
        //         list.add(nestedIterator);
        //     } else {
        //         dfs(nestedIterator.getList);
        //     }
        // }
    }
}
