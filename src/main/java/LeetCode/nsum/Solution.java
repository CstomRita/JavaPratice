package LeetCode.nsum;

import java.util.*;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 下午3:04 2018/9/20
 * @ Description：Solution for Nnums
 * @ Modified By：
 * @Version: $
 */
public class Solution {

    //双指针法
    private static List<List<Integer>>  twoNum1(int[] nums,int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        while(start < end) {
            int num1 = nums[start];
            int num2 = nums[end];
            if(num1 + num2 == target) {
                result.add(Arrays.asList(new Integer[]{num1,num2}));
                while(start < end && nums[++start] == num1){}
                while(start < end && nums[--end] == num2){}
            }else if(num1 + num2 > target) {
                end--;
            }else{
                start++;
            }
        }
        return result;
    }

//    哈希表
    private static List<List<Integer>>  twoNum2(int[] nums,int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i]) && 2*nums[i] != target) continue;
            if(set.contains(target - nums[i])) {
                result.add(Arrays.asList(new Integer[]{nums[i],target-nums[i]}));
            }
            set.add(nums[i]);
        }
        return result;
    }

    //3元组 双向指针法

    private static List<List<Integer>> threeNum1(int[] nums, int target) {
        // 要排序的
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i = 0; i < nums.length - 2; i++) {
            if(i !=0 && nums[i-1] == nums[i]) {
                continue;
            }
            int newTarget = target - nums[i];
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int num1 = nums[start];
                int num2 = nums[end];
                if(num1 + num2 == newTarget) {
                    result.add(Arrays.asList(new Integer[]{nums[i],num1,num2}));
                    while(start < end && nums[++start] == num1){}
                    while(start < end && nums[--end] == num2){}
                }else if (num1 + num2 < newTarget) {
                    start++;
                }else {
                    end--;
                }
            }
        }
        return result;
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-3; i++) {
            if(i!=0 && nums[i] == nums[i-1]) continue;
            for(int j = i + 1;j < nums.length-2; j++) {
                if(j!= i+1 && nums[j-1] == nums[j]) continue;
                int newTarget = target - nums[i] - nums[j];
                int start = j + 1;
                int end = nums.length - 1;
                while(start < end) {
                    int sum = nums[start] + nums[end];
                    if(sum == newTarget) {
                        int startNum = nums[start];
                        int endNum = nums[end];
                        result.add(Arrays.asList(new Integer[]{nums[i],nums[j],startNum,endNum}));
                        while(start < end && nums[++start]== startNum) {}
                        while(start < end && nums[--end] == endNum) {}
                    }else if(sum > newTarget) {
                        end--;
                    }else{
                        start++;
                    }
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        //System.out.println(twoNum1(new int[]{1,3,5,8,2,3,7,0},8).toString());
        System.out.println(twoNum1(new int[]{-1,0,1,2},1).toString());
        System.out.println(threeNum1(new int[]{-2,0,0,2,2},0));
        System.out.println('0'-1);
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<String> arrayList = new ArrayList<String>();
        String s = "";
    }
}
