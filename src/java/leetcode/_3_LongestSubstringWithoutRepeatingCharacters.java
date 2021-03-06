package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Examples:
 *
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 *
 * Given "bbbbb", the answer is "b", with the length of 1.
 *
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *
 * @Description:
 * @Date: 2018-05-20
 */
public class _3_LongestSubstringWithoutRepeatingCharacters {


    public int lengthOfLongestSubstring(String s) {

        if (s == null) {
            return 0;
        }
        // char -> position
        Map<Character, Integer> map = new HashMap<>();

        int max = 0;
        int tmp = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {

            if (!map.containsKey(chars[i])) {
                map.put(chars[i], i);
                tmp++;
                if (tmp > max) {
                    max = tmp;
                }
            } else {
                Integer p = map.get(chars[i]);
                tmp = i - p;
                if (tmp > max) {
                    max = tmp;
                }
                map.put(chars[i], i);
            }
        }

        System.out.println(1);
        System.out.println(2);
        System.out.println(3);
        System.out.println(4);
        System.out.println(5);
        System.out.println(5);
        return max;
    }
}
