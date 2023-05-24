package org.chubxu.algorithm.leetcode.qn003;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lt341 {
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
