package com.hbc.myList;

import java.sql.SQLOutput;
import java.util.Arrays;

/**
 * @Author: Beer
 * @Date: 2019/3/3 23:05
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        SequenceLinkImpl sl = new SequenceLinkImpl();
        sl.add(1);
        sl.add(2);
        sl.add(3);
        sl.add(4);
        sl.add(5);
        System.out.println(Arrays.toString(sl.toArray()));//[1,2,3,4,5]
        System.out.println(sl.get(2));//2
        sl.set(3,7);
        System.out.println(Arrays.toString(sl.toArray()));//[1,2,3,7,5]
        sl.remove(3);
        System.out.println(Arrays.toString(sl.toArray()));//[1,2,3,5]
        System.out.println(sl.isContains(0));//false
        sl.clear();
        System.out.println(Arrays.toString(sl.toArray()));//

    }
}
