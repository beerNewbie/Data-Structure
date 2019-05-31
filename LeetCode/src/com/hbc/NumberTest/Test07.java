package com.hbc.NumberTest;

/**
 * @Author: Beer
 * @Date: 2019/5/31 18:10
 * @Description: 求n!数末尾后0的个数
 *  那么我们在计算n的阶乘时，实际上就是把所有小于等于n的正整数分解成质因数，
 *  然后再将其乘到一起，那么末尾0的个数实际上就是2*5的个数，而2的个数明显
 *  是很多很多的，所以问题就转化成了5的个数。
 *
 */
public class Test07 {
    public static int fun(int n) {
        int res = 0;
        for(int i = n; i >= 5; i--) {
            int tmp = i;
            while(tmp % 5 == 0) {
                res++;
                tmp /= 5;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(fun(10));//2
    }
}
