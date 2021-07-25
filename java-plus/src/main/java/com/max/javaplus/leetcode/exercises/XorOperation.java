package com.max.javaplus.leetcode.exercises;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className XorOperation
 * @date 2021/5/7 9:22
 * @desc 数组异或操作
 **/
public class XorOperation {
    /**
     * 给你两个整数，n 和 start 。
     * <p>
     * 数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。
     * <p>
     * 请返回 nums 中所有元素按位异或（XOR）后得到的结果。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/xor-operation-in-an-array
     **/


    public static void main(String[] args) {

        int operation = xorOperation(5, 0);
        System.out.println(operation);
    }

    public static int xorOperation(int n, int start) {
        int[] nums = new int[n];
        int result = 0;

        // 添加数组元素
        for (int i = 0; i < n; i++) {
            nums[i] = start + 2 * i;
        }

        // 求出XOR结果
        for (int j = 0; j < n; j++) {
            result = result ^ nums[j];
        }

        return result;
    }
}
