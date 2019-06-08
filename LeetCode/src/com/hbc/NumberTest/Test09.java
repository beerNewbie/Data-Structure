package com.hbc.NumberTest;

/**
 * @Author: Beer
 * @Date: 2019/6/9 0:36
 * @Description: 百万富翁问题
 *
 *富翁每天给陌生人10万，陌生人给富翁第一天1分，第二天2分，第三天4分....30天后各给出了多少钱？
 */
public class Test09 {
    public static void main(String[] args) {
        long stranger = 1;
        long rich = 10*30;
        for (int i = 1; i < 30; i++) {
            stranger += Math.pow(2,i);
        }
        System.out.println(rich+" "+stranger);//300 1073741823
    }
}
