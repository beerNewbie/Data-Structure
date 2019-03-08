package com.hbc.mySort;

/**
 * @Author: Beer
 * @Date: 2019/3/7 19:34
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        int[] array = new int[] {6,3,2,4,1,5};
        //bubbleSort(array);
        insertSort(array);
        SortHelper.printArray(array);
    }

    public static void bubbleSort(int[] array) {
        int size = array.length;
        if (size <= 1){
            return;
        }
        for (int i = 0; i < size; i++) {
            boolean flag = false;
            for (int j = 0; j < size-i-1; j++) {
                if (array[j] > array[j+1]) {
                    flag = true;
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
            if (!flag) {
                return;
            }
        }
    }

    public static void insertSort(int[] array) {
        int n = array.length;
        if (n <= 1) {
            return;
        }else {
            for (int i = 1; i < n; i++) {
                int val = array[i];
                int j = i - 1;
                for (;j >= 0; j--){
                    if (array[j+1] < array[j]){
                        array[j+1] = array[j];
                        array[j] = val;
                    }else {
                        break;
                    }
                }

            }
        }
    }
}
