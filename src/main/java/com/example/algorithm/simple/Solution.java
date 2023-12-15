package com.example.algorithm.simple;

import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Objects;

import static java.util.Arrays.sort;

/**
 * 力扣 1.两数之和
 * https://leetcode.cn/problems/two-sum/description/
 *
 * @version V1.0
 * @date: 2023年12月13日 23时06分
 */
@Controller
public class Solution {

    // 哈希表
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int targetNum = target - nums[i];
            if (numsMap.containsKey(targetNum)) {
                return new int[]{i, numsMap.get(targetNum)};
            }
            numsMap.put(nums[i], i);
        }
        return new int[]{};
    }

    // 暴力破解 - 两层for循环
    /*public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }*/


    // 失败的二分查找
    /*public int[] twoSum(int[] nums, int target) {
        // 先进行升序排序
        sort(nums);
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int findNum = target - nums[i];

            int leftIndex = i + 1;
            int rightIndex = length - 1;
            int index = binarySearch(nums, findNum, leftIndex, rightIndex);
            if (index != -1) {
                // 找到目标值，返回索引数组
                return new int[]{i, index};
            }
        }
        return new int[]{};
    }*/

    /**
     * 二分查找
     *
     * @param nums 数组
     * @param findNum 要查找的数值
     * @param left 左边索引
     * @param right 右边索引
     * @return 查询到的索引，未查询到返回-1
     */
    private int binarySearch(int[] nums, int findNum, int left, int right) {
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == findNum) {
                // 找到目标值，返回索引
                return mid;
            } else if (nums[mid] > findNum) {
                // 目标值在左半部分，更新右边界
                right = mid -1;
            } else {
                // 目标值在右半部分，更新左边界
                left = mid + 1;
            }
        }
        return -1;
    }
}
