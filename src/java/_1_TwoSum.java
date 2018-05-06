import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/description/
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 * @Description:
 * @Author: sunweiqiang
 * @Date: 2018-05-06
 */
public class _1_TwoSum {

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }

        int[] result = new int[2];
        // K: val V:position
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int n1 = nums[i];
            if (map.containsKey(target - n1)) {
                int index2 = map.get(target - n1);
                // 如果下标相同，舍弃
                if (i != index2) {
                    result[0] = i;
                    result[1] = index2;
                    return result;
                }
            } else {
                map.put(nums[i], i);
            }
        }

        return null;
    }

}
