package com.hbc.WrittenTest;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        //ArrayList<Integer> list = new ArrayList<>();
        int[] arr = new int[n];
        int[] nums = new int[q];
        for (int i = 0; i < n; i++) {
            //list.add(sc.nextInt());
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        for (int i = 0; i < q; i++) {
            nums[i] = sc.nextInt();
            //int count = 0;

        }
        for (int e : nums) {
            int res = find(arr,e);
            int count = fun(arr,res);
            System.out.println(count);
        }

    }

    public static int find(int[] arr, int k) {
        int r = arr.length-1;
        int l = 0;
        int res = arr.length-1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] > k) {
                res = mid;
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return  res;
    }

    public static int  fun(int[] arr, int n) {
        int count = 0;
        for (int i = n; i < arr.length; i++) {
            arr[n] = arr[n] - 1;
            count++;
        }
        return  count;
    }
}

/*
4 3
1 2 3 4
4
3
2
 */