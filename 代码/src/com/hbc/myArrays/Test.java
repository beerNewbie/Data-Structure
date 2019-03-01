package com.hbc.myArrays;

import java.util.Arrays;

/**
 * @Author: Beer
 * @Date: 2019/3/1 23:09
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        Sequence sq = new SequenceArrayImpl();
        sq.add(0);
        sq.add(2);
        sq.add(3);
        Object obj = new Object();
        obj = sq.set(0,1);
        System.out.println(sq.get(0));
        System.out.println(Arrays.toString(sq.toArray()));
        System.out.println(sq.isContains(8));
        obj = sq.remove(2);
        System.out.println(Arrays.toString(sq.toArray()));

    }
}
