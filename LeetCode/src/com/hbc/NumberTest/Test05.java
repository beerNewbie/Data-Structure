package com.hbc.NumberTest;

/**
 * @Author: Beer
 * @Date: 2019/5/23 15:05
 * @Description: 分治思想寻找数组第K大数值
 *
 * 思想：例如找49个元素里面第24大的元素，那么按如下步骤： 1.进行一次快排（将大的
 * 元素放在前半段，小的元素放在后半段）,假设得到的中轴为p 2.判断 p - low + 1 == k ，如果成立，直接输出
 * a[p]，（因为前半段有k - 1个大于a[p]的元素，故a[p]为第K大的元素） 3.如果 p - low + 1 > k， 则第k大的元
 * 素在前半段，此时更新high = p - 1，继续进行步骤1 4.如果p - low + 1 < k， 则第k大的元素在后半段， 此时
 * 更新low = p + 1, 且 k = k - (p - low + 1)，继续步骤1. 由于常规快排要得到整体有序的数组，而此方法每次可
 * 以去掉“一半”的元素，故实际的复杂度不是o(nlgn), 而是o(n)。
 */
public class Test05 {
    public static void main(String[] args) {
        System.out.println(findKth(new int[]{1,3,8,5,3,6}, 6, 2));
    }
    public static int findKth(int[] a, int n, int K) {
        return findK(a,0,n-1,K);
    }
    public static int findK(int[] a, int l, int r, int K) {
        int part = partition(a,l,r);
        //此时part位置为第K大元素
        if (K == part - l +1) return a[part];
        else if (K > part - l + 1) return findK(a,part+1,r,K-part+l-1);
        else return findK(a,l,part-1,K);
    }
    public static int partition(int[] a, int l, int r) {
        int key = a[l];
        while (l < r) {
            while (l < r && a[r] <= key) r--;
            a[l] = a[r];
            while (l < r && a[l] >= key) l++;
            a[r] = a[l];
        }
        a[l] = key;
        return l;
    }
}
