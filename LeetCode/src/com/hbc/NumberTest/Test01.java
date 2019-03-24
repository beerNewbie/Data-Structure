package com.hbc.NumberTest;

import java.util.InputMismatchException;

/**
 * @Author: Beer
 * @Date: 2019/3/24 22:20
 * @Description:快乐数
 */

public class Test01 {
    public static boolean isHappy(int n) {
        if(n <= 0){
            throw new InputMismatchException("Illegal input");
        }
        while (n >= 10) {
            int temp = n;
            int sum = 0;
            while (temp != 0) {
                sum += (int)Math.pow(temp%10,2);
                temp /= 10;
            }
            n = sum;
        }
        return n == 1 || n == 7;
    }
    public static void main(String[] args) {
        System.out.println(isHappy(0));
    }
}
