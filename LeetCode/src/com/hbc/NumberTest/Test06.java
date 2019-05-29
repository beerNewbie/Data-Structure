package com.hbc.NumberTest;

/**
 * @Author: Beer
 * @Date: 2019/5/29 11:45
 * @Description: 求最小公倍数
 */


public class Test06 {
    //方法一直接遍历法
    public static int lcm1(int a, int b) {
        if (a == b) return a;
        else {
            for (int i = 1; i <= b; i++) {
                if (a * i % b == 0) {
                    return a * i;
                }
            }
        }
        return 0;
    }
    //方法二，通过公式最小公倍数等于a乘以b除以最小公约数
    //最小公约数:递归
    public static int gcb(int a, int b) {
        if (b == 0) return a;
        else
            return gcb(b, a % b);
    }
    //最小公约数
    public static int lcm2(int a, int b) {
        return a * b / gcb(a, b);
    }

    public static void main(String[] args) {
        System.out.println(lcm1(12,16));//48
        System.out.println(lcm2(12,16));//48
    }
}
