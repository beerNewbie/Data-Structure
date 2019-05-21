package com.hbc.StringTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: Beer
 * @Date: 2019/5/21 23:17
 * @Description: 将字符串转换成整数
 */
public class Test03 {
    //badMethod
    public static int myAtoi1(String str) {
        if (str == null || str.length() == 0 || str.trim().isEmpty()) {
            return 0;
        }
        //首先将字符串转化为字符数组
        char[] arr = str.toCharArray();
        //排除前面为空的字符
        int i = 0;
        while (arr[i] == ' ') {
            i++;
        }
        //判断以0开头的特殊情况：1.全部为0；2.遇到非数字字符
        while (i < arr.length && arr[i] == '0') {
            i++;
            if (i == arr.length) return 0;
            if (!Character.isDigit(arr[i])) return 0;
        }
        //非数字字符开头
        if (!Character.isDigit(arr[i])) {
            //以+-号开头
            if (arr[i] == '-' || arr[i] == '+') {
                if (i == arr.length-1 || !Character.isDigit(arr[i+1])) return 0;
                int m = i;
                while (i < arr.length && arr[i+1] == '0') {
                    i++;
                    if (i == arr.length) return 0;
                }
                return arr[m] == '-' ? changeChar(arr,i+1,true) : changeChar(arr,i+1,false);
            }else {
                return 0;
            }
        }else {
            //数字开头
            return changeChar(arr,i,false);
        }

    }
    //将数字开头的转换为int
    public static int changeChar(char[] arr, int l,boolean flag) {
        int i = l;
        for (; i < arr.length; i++){
            if (!Character.isDigit(arr[i])) {
                break;
            }
        }
        if (i == l) {
            return 0;
        }
        String str = new String(arr);
        str = str.substring(l,i);
        if (str.length() - l > 11) {
            return flag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        long num = Long.parseLong(str);
        return flag ? (num*(-1) < Integer.MIN_VALUE ? Integer.MIN_VALUE : (int)num*(-1)) : (num > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)num);

    }

    //方法2：根据正则表达式判断
    public static int myAtoi(String str) {
        //首先去掉空格
        str = str.trim();

        //再根据正则表达式得到匹配对象
        String pattern = "^[\\+\\-\\d]\\d*";//正则表达式，表示以正号或负号或数字开头，且后面是0个或多个数字
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(str);

        //得到能匹配到的字符串
        String re = null;
        if (m.find()) {
            re = str.substring(m.start(),m.end());
        }else {
            return 0;
        }

        //能匹配到但只有一个+或-：
        if (re.length() == 1 && (re.charAt(0) == '+' || re.charAt(0) == '-')) {
            return 0;
        }

        //通过try-catch返回整型值：
        try{
            int result = Integer.parseInt(re);
            return result;
        }catch(Exception e) {
            //只能根据负号判断
            return re.charAt(0) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
    }



    public static void main(String[] args) {
        System.out.println(myAtoi(" -0089kdjhh"));
    }
}
