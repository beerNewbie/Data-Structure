package com.hbc.StringTest;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @Author: Beer
 * @Date: 2019/6/8 23:04
 * @Description: DNA序列
 *
 *  一串字符（序列）中某一连续长度内出现特定字符最多的子序列
 *
 *  （1）TreeMap中按照key值大小进行排序
 *  （2）获取最大key值（即最后一个键值对的value值）：
 *      map.get(((TreeMap<Integer,Integer>) map).last));
 */
public class Test06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = sc.nextInt();
        char[] ch = str.toCharArray();
        Map<Integer,Integer> map = new TreeMap<>();
        for (int i = ch.length-n; i >= 0; i--) {
            map.put(ratio(ch,i,n),i);
        }
        //获取最大key的值
        int findIndex = map.get(((TreeMap<Integer, Integer>) map).lastKey());
        StringBuilder sb = new StringBuilder();
        for (int i = findIndex; i < findIndex + n; i++) {
            sb = sb.append(ch[i]);
        }
        System.out.println(sb.toString());
    }
    public static int ratio(char[] ch, int n, int m) {
        int count = 0;
        for (int i = n; i <n + m; i++) {
            if (ch[i] == 'G' || ch[i] == 'C') {
                count ++;
            }
        }
        return count;
    }
}
