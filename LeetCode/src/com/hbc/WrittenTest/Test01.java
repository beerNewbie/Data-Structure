package com.hbc.WrittenTest;


import java.util.Arrays;

/**
 * @Author: Beer
 * @Date: 2019/8/9 16:29
 * @Description: 公交路线
 *
 *      从小明家所在公交站出发有n路公交到公司，现给出每路公交的停站数(
 * 不包括起点和终点)，及每次停的时间(一路车在每个站停的时间相同)和
 * 发车的间隔，先假定每辆车同时在相对时间0分开始发车，且所有车在相
 * 邻两个站之间的耗时相同,都为5分钟。给定小明起床的相对时间(相对0的
 * 分钟数)，请计算他最早到达公司的相对时间。
 *
 *      给定每路车的停站数stops,停站时间period,发车间隔interval及公交路
 * 数n，出发时间s。请返回最早到达时间。保证公交路数小于等于500，停
 * 站数小于等于50。
 */

public class Test01 {
    public static void main(String[] args) {
        int[] stops = new int[] {2,4,6,2,3,8,6};
        int[] period = new int[] {3,5,2,2,3,2,5};
        int[] interval = new int[] {5,3,5,6,3,4,5};
        int n = 7;
        int s = 15;
        System.out.println(chooseLine(stops,period,interval,n,s));//36
    }

    public static int chooseLine(int[] stops, int[] period, int[] interval, int n, int s) {
        int[] min = new int[n];
        for (int i = 0; i < n; i++) {
            //路上停站时间与行车时间之和
            min[i] = stops[i] * period[i] + (stops[i] + 1) * 5;
            if (s % interval[i] == 0) {
                continue;
            } else {
                //出发等待时间
                min[i] = min[i] + interval[i] - (s % interval[i]);
            }
        }
        Arrays.sort(min);
        return min[0] + s;
    }
}
