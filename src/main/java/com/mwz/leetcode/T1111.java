package com.mwz.leetcode;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class T1111 {

    public int[] maxDepthAfterSplit(String seq) {
        int deep = 0;
        char[] chars = seq.toCharArray();
        int[] rs = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch == '(') {
                deep++;
                rs[i] = deep % 2;
            } else {
                rs[i] = deep++ % 2;
            }
        }

        return rs;
    }

}
