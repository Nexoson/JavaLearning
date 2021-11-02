package com.max.javaplus.leetcode.sort_algorithm;

/**
 * @author max66
 *
 * 未完待续
 * https://www.jianshu.com/p/47170b1ced23
 */
public class MySort {

    public static void main(String[] args) {
        int[] initArr = GetInitArr.getInitData();
//        int[] integers = bubbleSort(initArr);
        int[] integers = cocktailSort(initArr);
//        int[] integers = selectionSort(initArr);
//        int[] integers = insertionSort(initArr);
        for (int i = integers.length - 1; i >= 0; i--) {
            System.out.println(integers[i]);
        }
    }

    /**
     * 冒泡排序- 交换排序
     */
    static int[] bubbleSort(int[] initArr) {
        int temp;
        for (int i = 0; i < initArr.length; i++) {
            for (int j = 0; j < initArr.length - 1; j++) {
                if (initArr[j] < initArr[j + 1]) {
                    temp = initArr[j];
                    initArr[j] = initArr[j + 1];
                    initArr[j + 1] = temp;
                }
            }
        }
        return initArr;
    }

    /**
     * 鸡尾酒排序(冒泡排序变种,优化) - 交换排序
     *
     * @param initArr 待排序数组
     * @author huangX
     * @date 14:04 2021/10/27
     **/
    static int[] cocktailSort(int[] initArr) {
/*      个人实现
        int temp;
        for (int i = 0; i < initArr.length; i++) {
            for (int j = i; j < initArr.length - i - 1; j++) {
                if (initArr[j] < initArr[j + 1]) {
                    temp = initArr[j];
                    initArr[j] = initArr[j + 1];
                    initArr[j + 1] = temp;

                }
            }
            for (int j = initArr.length - i - 1; j > i; j--) {
                if (initArr[j - 1] < initArr[j]) {
                    temp = initArr[j];
                    initArr[j] = initArr[j - 1];
                    initArr[j - 1] = temp;
                }
            }
        }
        return initArr;*/
        int left = 0, right = initArr.length - 1;
        while (left < right) {
            for (int i = left; i < right; i++) {
                if (initArr[i] > initArr[i + 1]) {
                    swap(initArr, i, i + 1);
                }
                right--;
            }
            for (int i = right; i > left; i--) {
                if (initArr[i] > initArr[i - 1]) {
                    swap(initArr, i, i - 1);
                }
                left++;
            }
        }
        return initArr;
    }

    /**
     * 简单选择排序
     * @author huangX
     * @date 14:07 2021/10/27
     **/
    static int[] selectionSort(int[] initArr) {
        if (initArr.length == 0) {
            return initArr;
        }
        for (int i = 0; i < initArr.length; i++) {
            int minIndex = i;
            for (int j = i; j < initArr.length; j++) {
                // 找到最小的数
                if (initArr[j] < initArr[minIndex]) {
                    // 将最小数的索引保存
                    minIndex = j;
                }
            }
            // 将最小数和无序区的第一个数交换
            int temp = initArr[minIndex];
            initArr[minIndex] = initArr[i];
            initArr[i] = temp;
        }
        return initArr;
    }

    /**
     * 直接插入排序
     *
     * @param array 待排序数组
     * @author huangX
     * @date 15:39 2021/10/27
     **/
    static int[] insertionSort(int[] array) {

        if (array.length == 0) {
            return array;
        }
        int current;
        for (int i = 1; i < array.length; i++) {
            current = array[i];
            int preIndex = i - 1;
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        return array;
    }


    /**
     * 快速排序
     *
     * @param initArr 待排序数组
     * @author huangX
     * @date 14:03 2021/10/27
     **/
    static int[] partitionSort(int[] initArr) {


        return null;
    }


    /**
     * 交换数组内两个元素
     *
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
