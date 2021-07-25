package com.max.javaplus.leetcode.sort_algorithm;

import java.util.List;

/**
 * @author max66
 */
public class MySort {

    public static void main(String[] args) {
        Integer[] initArr = GetInitArr.getInitData();
        Integer[] integers = bubbleSort(initArr);
        for (int i = integers.length - 1; i >= 0; i--) {
            System.out.println(integers[i]);
        }
    }

    /**
     * 冒泡排序
     *
     * @return
     */
    static Integer[] bubbleSort(Integer[] initArr) {

        int temp;
        for (int i = 0; i < initArr.length; i++) {
            for (int j = 0; j < initArr.length-1; j++) {
                if (initArr[j] > initArr[j + 1]) {
                    temp = initArr[j];
                    initArr[j] = initArr[j+1];
                    initArr[j+1] = temp;
                }
            }
        }
        return initArr;
    }
}
