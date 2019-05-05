
package com.hbc.NumberTest;
/**
 * @Author: Beer
 * @Date: 2019/5/5 22:50
 * @Description: 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转
 */
public class Test04 {
    public static int reverse(int x) {
        //思路1：把整数转为字符串
        /**
         long y = x >= 0 ? x : x*(-1l);
         long i = Long.valueOf(new StringBuffer(String.valueOf(y)).reverse().toString());
         return (Integer.MAX_VALUE >= i && i >= Integer.MIN_VALUE) ? (x > 0 ? (int)i : (int)i*(-1)) : 0;
         */
        //思路2：直接通过拆分，求和得到反转值2^31-1=2147483647,-2^31=-2147483648
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            //判断溢出条件，(temp = rev*10+pop) > 2147483647,即rev>214748364或者rev==214748364&&pop>7;为负数时同理
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;

    }
    public static void main(String[] args) {
        System.out.println(reverse(2387732));
        System.out.println(reverse(-2000000009));
        System.out.println(reverse(-87732));
    }
}
/**
 * 结果：
 * 2377832
 * 0
 * -23778
 */
