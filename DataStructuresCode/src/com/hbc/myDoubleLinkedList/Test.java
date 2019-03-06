package com.hbc.myDoubleLinkedList;

import java.util.Arrays;

/**
 * @Author: Beer
 * @Date: 2019/3/6 12:01
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        DoubleLinkedListImpl d = new DoubleLinkedListImpl();
        d.add(1);
        d.add(2);
        d.add(3);
        d.add(4);
        d.add(5);
        d.set(3,6);
        System.out.println(Arrays.toString(d.toArray()));//[1,2,3,6]
        d.remove(4);
        System.out.println(Arrays.toString(d.toArray()));//[1,2,3,5]
        System.out.println(d.get(3));//6
        System.out.println(d.isContains(6));//true
    }
}
