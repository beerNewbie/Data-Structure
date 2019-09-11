package com.hbc.WrittenTest;

import java.util.*;
/**
 * @Author: Beer
 * @Date: 2019/9/11 18:58
 * @Description:
 */

public class Main2 {


    static int solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.println(count);
            count = count + Math.abs(i - list.indexOf((Integer) arr[i]));
        }
        return count/2;

    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;


        int[] _arr = {4,2,7,6};

        res = solution(_arr);
        System.out.println(String.valueOf(res));

    }
}
