package com.hbc.NumberTest;

/**
 * @Author: Beer
 * @Date: 2019/3/27 23:12
 * @Description:十进制整数的反码
 * 输入：5
 * 输出：2
 * 解释：5 的二进制表示为 "101"，其二进制反码为 "010"，也就是十进制中的 2 。
 */

public class Test02 {
    public static int bitwiseComplement(int N) {
        /**

        //问题？？？10进制化二进制？二进制的补码？二进制化十进制
        // 方法一：
         //十进制转二进制
        int[] arr = new int[32];
        for (int i = 31; i >= 0; i--){
            arr[i] = (N >>> i & 1);
        }
        int count = 31;
        while(true){
            if(arr[count] != 0){
                break;
            }
            count--;
            if(count == 0){
                if(arr[count] == 0){
                    return 1;
                }else{
                    return 0;
                }
            }
        }
        int[] newArr = new int[count+1];
        for(int i = 0; i <= count; i++){
            if(arr[i] == 0){
                newArr[i] = 1;
            }
            if(arr[i] == 1){
                newArr[i] = 0;
            }
        }
        int j = 0;
        int sum = 0;
        for(int i = 0; i <= count; i++){
            if(newArr[i] == 1){
                sum += (int)Math.pow(2,j);
            }
            j++;
        }
        return sum;
         */
         int i,M = N;
         for(i = 1; i <= N; i <<= 1) {
             M = M ^ i;
         }
         return N == 0 ? 1 : M;
    }

    public static void main(String[] args) {
        System.out.println(bitwiseComplement(5));
    }
}
