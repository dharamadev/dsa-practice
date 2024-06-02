package com.techendear.search.binary;

public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, -1, 0, 1, 2};
        int num = 1;
        int target = 0;
        while (num < nums.length && !(nums[num] > nums[num + 1] && nums[num] > nums[num - 1])) {
            num++;
        }
        System.out.println("Index of target:: " + Math.max(search(nums, target, 0, num), search(nums, target, num + 1, nums.length - 1)));
    }

    public static int search(int[] nums, int target, int start, int end) {
        if (target == nums[start]) return start;
        if (target == nums[end]) return end;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) return mid;
            start++;
        }
        return -1;
    }

}
