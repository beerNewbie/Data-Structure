package com.hbc.NumberTest;

import java.util.Scanner;

/**
 * @Author: Beer
 * @Date: 2019/6/5 22:54
 * @Description: （饥饿的小易）通过两函数求达到某一值的次数
 *
 *      f(x)=4*x+3   g(x)=8*x+7
 *   1）g(f(x))=f(g(x))   即f和g的执行顺序没有影响。
 *   2) f(f(f(x)))=g(g(x))    即做3次f变换等价于做2次g变换
 *    因此最小次数是f(x)的出现次数为0、1、或 2；
 */
public class Test08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int des = 1000000007;
        long[] arr = new long[3];
        arr[0] = p;
        arr[1] = (4*p+3) % des;
        arr[2] = (4*(4*p+3)+3) % des;
        long minStep = 100000;
        long cur = 0;
        int step = 0;
        for (int i = 0; i < 3; i++) {
            cur = arr[i];
            step = i;
            while (cur != 0 && step <= minStep) {
                cur = (8*cur+7) % des;
                step ++;
            }
            minStep = minStep < step ? minStep : step;
        }
        if (minStep < 100000) {
            System.out.println(minStep);
        }else {
            System.out.println(-1);
        }
    }
}
