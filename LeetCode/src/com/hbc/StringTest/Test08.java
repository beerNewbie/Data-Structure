package com.hbc.StringTest;

import java.util.*;

/**
 * @Author: Beer
 * @Date: 2019/7/24 15:19
 * @Description: 筛选电话号码
 *
 *      现在给你一串电话号码列表，请你帮他转
 * 换成数字形式的号码，并去除重复的部分。
 */
public class Test08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String letter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String number = "222333444555666777788899991234567890";
        while (sc.hasNext()) {
            int n = sc.nextInt();
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                //注意是sc.next()不是sc.nextLine()
                String str = sc.next();
                //去掉电话号码中的"-"
                str = str.replace("-","");
                String res = "";
                //将字母号码转化为数字号码
                for (int j = 0; j < 7; j++) {
                    res += number.charAt(letter.indexOf(str.charAt(j)+""));
                }
                res = res.substring(0,3)+"-"+res.substring(3,7);
                //保证不重复
                if (!list.contains(res)) {
                    list.add(res);
                }
            }
            //以字典序列排序并输出
            Collections.sort(list);
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
            System.out.println();

        }
    }
/**
 * 输入：
 * 12
 * 4873279
 * ITS-EASY
 * 888-4567
 * 3-10-10-10
 * 888-GLOP
 * TUT-GLOP
 * 967-11-11
 * 310-GINO
 * F101010
 * 888-1200
 * -4-8-7-3-2-7-9-
 * 487-3279
 * 4
 * UTT-HELP
 * TUT-GLOP
 * 310-GINO
 * 000-1213
 *
 *
 * 结果：
 * 310-1010
 * 310-4466
 * 487-3279
 * 888-1200
 * 888-4567
 * 967-1111
 *
 * 000-1213
 * 310-4466
 * 888-4357
 * 888-4567
 */


}




