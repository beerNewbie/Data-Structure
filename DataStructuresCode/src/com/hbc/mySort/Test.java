package com.hbc.mySort;

/**
 * @Author: Beer
 * @Date: 2019/3/7 19:34
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
       //int[] array = new int[] {6,3,2,7,4,1,5};
       //int[] array = SortHelper.creatRandomArray(10000000,0,999999);
        int[] array = SortHelper.generateNearlySortedArray(1000000,10);
        //bubbleSort(array);
        //insertSort(SortHelper.copyArray(array));
        //binaryInsertSort(SortHelper.copyArray(array));
        //shellSort(SortHelper.copyArray(array));
        //selectionSort(SortHelper.copyArray(array));
        mergeSort(SortHelper.copyArray(array));
        //SortHelper.printArray(array);
        //System.out.println("\n**************");
        quickSort(array);
        //SortHelper.printArray(array);
    }

    //冒泡排序
    public static void bubbleSort(int[] array) {
        long start = System.currentTimeMillis();
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
                break;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("冒泡排序耗时：" + (end - start) + "毫秒");
    }

    //直接插入排序
    public static void insertSort(int[] array) {
        long start = System.currentTimeMillis();

        int n = array.length;
        if (n <= 1) {
            return;
        }else {
            for (int i = 1; i < n; i++) {
                int val = array[i];
                int j = i - 1;
                for (;j >= 0; j--){
                    if (array[j] > val){
                        array[j+1] = array[j];
                    }else {
                        break;
                    }
                }
                array[j+1] = val;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("直接插入排序耗时：" + (end - start) + "毫秒");
    }

    //折半插入排序
    public static void binaryInsertSort(int[] array) {
        long start = System.currentTimeMillis();

        int n = array.length;
        if (n <= 1) {
            return;
        }
        for (int i = 1; i < n; i++) {
            int val = array[i];
            int j = i - 1;
            int low = 0;
            int high = i - 1;
            while(low <= high) {
                int mid = low + (high - low) / 2;
                if (array[mid] >= val) {
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }
            //找到插入位置high+1
            for (; j >= high+1; j--) {
                array[j+1] = array[j];
            }
            array[j+1] = val;
        }
        long end = System.currentTimeMillis();
        System.out.println("折半插入排序耗时：" + (end - start) + "毫秒");
    }

    //希尔排序
    public static void shellSort(int[] array) {
        long start = System.currentTimeMillis();

        int n = array.length;
        if (n <= 1) {
            return;
        }
        int step = n / 2;
        while(step >= 1) {
            for (int i = step; i < n; i++) {//缩小增量
                int val = array[i];
                int j = i - step;//j的值为i-step;
                for (; j >= 0; j -= step) {//只进行了一次交换
                    if (array[j] > val) {
                        array[j+step] = array[j];
                    }else{//如若无需排序则要break；
                        break;
                    }
                }
                array[j+step] = val;
            }
            step /= 2;
        }
        long end = System.currentTimeMillis();
        System.out.println("希尔排序耗时：" + (end - start) + "毫秒");
    }

    //选择排序
    public static void selectionSort(int[] array) {
        long start = System.currentTimeMillis();

        int n = array.length;
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n - 1; i++ ){//i<n-1,因为是和后面的比较
            int min = i;
            for (int j = i + 1; j < n; j++){
                if (array[min] > array[j]) {
                    min = j;//已查找出最小值的下标
                }
            }
            //再根据下标将array[i]与array[mid]进行交换
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
        long end = System.currentTimeMillis();
        System.out.println("选择排序耗时：" + (end - start) + "毫秒");
    }

    //归并排序
    public static void mergeSort(int[] array) {
        long start = System.currentTimeMillis();
        int n = array.length;
        if (n <=  1) {
            return;
        }
        int p = 0;
        int r = n - 1;
        mergeSortIntern(array,p,r);
        long end = System.currentTimeMillis();
        System.out.println("归并排序耗时：" + (end - start) + "毫秒");
    }
    private static void mergeSortIntern(int[] array, int p, int r) {
        if (p >=  r) {
            return;
        }
        int mid = p + (r-p)/2;
        //左边
        mergeSortIntern(array,p,mid);
        //右边
        mergeSortIntern(array,mid+1,r);
        //合并
        merge(array,p,mid,r);
    }
    private static void merge(int[] array, int p, int mid, int r) {
        //合并思路：将左右两边中最小的依次放入新数组temp中并将剩余值也放入，再将temp拷贝回源数组
        //定义左右两边与新数组的起始下标i,j,k
        int i = p;
        int j = mid+1;
        int k = 0;
        int[] temp = new int[r-p+1];
        while (i <= mid && j <= r) {
            if (array[i] <= array[j]){
                temp[k++] = array[i++];
            }else{
                temp[k++] = array[j++];
            }
        }
        //将剩余元素置入数组中
        int start = i;
        int end = mid;
        if (j <= r) {//右边还有元素剩余
            start = j;
            end = r;
        }
        while(start <= end) {
            temp[k++] = array[start++];
        }
        //将新数组拷贝到原数组
        for (int m = 0; m < r-p+1; m++) {
            array[p+m] = temp[m];//注意 array起始下标为p+m;不是m;因为右边的起始下标为p(mid+1)不是0；
        }
    }

    //快速排序
    public static void quickSort(int[] array) {
        long start = System.currentTimeMillis();
        int n = array.length;
        if (n <= 1) {
            return;
        }
        quickSortIntern3(array,0,n-1);
        long end = System.currentTimeMillis();
        System.out.println("快排耗时：" + (end - start) + "毫秒");
    }
    private static void quickSortIntern(int[] array, int l, int r) {
        if (l >= r) {
            return;
        }
        int q = partition2(array,l,r);
        quickSortIntern(array,l,q-1);
        quickSortIntern(array,q+1,r);
    }
    private static int partition(int[] array,int l,int r) {
        int randomIndex = (int)(Math.random() * (r-l+1) + l);
        swap(array,l,randomIndex);
        int v = array[l];//基准值
        int j = l;//比基准值小的范围[l+1,j]
        int i = l+1;//比基准值大的范围[j+1,i-1],i是当前索引
        for (;i <= r; i++) {
            if (array[i] < v) {
                swap(array,j+1,i);
                j++;
            }
        }
        swap(array,l,j);
        return j;
    }
    //二路快排:通过双指针进行遍历
    private static int partition2(int[] array ,int l, int r) {
        int randomIndex = (int)(Math.random() * (r-l+1) + l);
        swap(array,l,randomIndex);
        int v = array[l];
        int i = l + 1;
        int j = r;
        while(true) {
            while(i <= r && array[i] < v) i++;//注意：不仅要判断值的大小，还要判断i,j下标是否越界
            while(j >= l + 1 && array[j] > v) j--;
            if (i > j) {
                break;
            }
            swap(array,i,j);
            i++;
            j--;
        }
       swap(array,l,j);
        return j;

    }
    //三路快排
    private static void quickSortIntern3(int[] array,int l,int r) {
        if (l >= r) {
            return;
        }
        int randomIndex = (int)(Math.random() * (r - l + 1)) + l;
        swap(array,l,randomIndex);
        int v = array[l];
        //array[l+1,...,lt] < v
        int lt = l;
        //array[gt,...,r] > v
        int gt = r + 1;
        //array[lt+1,...,i-1] == v
        int i = l + 1;
        while (i < gt) {//注意：判断条件是i < gt时
            if (array[i] < v) {
                swap(array,lt+1,i);
                i++;
                lt++;
            } else if (array[i] > v) {
                swap(array,gt-1,i);
                gt--;
            }else {
                i++;
            }
        }
        swap(array,l,lt);//最后换的是谁？？？lt
        quickSortIntern3(array,l,lt-1);
        quickSortIntern3(array,gt,r);
    }
    private static void swap(int[] array, int indexA, int indexB) {
        int temp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = temp;
    }


}
