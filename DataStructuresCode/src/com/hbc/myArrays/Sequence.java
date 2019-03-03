package com.hbc.myArrays;

/**
 * @Author: Beer
 * @Date: 2019/3/1 21:23
 * @Description:
 */
public interface Sequence {
    void add(Object data);
    Object remove(int index);
    Object set(int index,Object newData);
    Object get(int index);
    boolean isContains(Object data);
    int size();
    Object[] toArray();
    void clear();
}
