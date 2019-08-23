package com.hbc.WrittenTest;

import java.util.*;

/**
 * @Author: Beer
 * @Date: 2019/8/23 19:06
 * @Description:  渡船问题
 */

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        int limit = sc.nextInt();
        String str = str1.replaceAll(" ", "");
        char[] chars = str.toCharArray();
        int[] arr = new int[chars.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = chars[i] - '0';
        }
        Arrays.sort(arr);
        int count = 0;
        int i = arr.length - 1;
        int j = 0;
        while (j <= i) {
            if (arr[i] + arr[j] <= limit) {
                count++;
                i--;
                j++;
            } else {
                i--;
                count++;
            }

        }
        System.out.println(count);
    }
    /**
     * 结果：
     * 2 3 1
     * 3
     * 2
     */
}
