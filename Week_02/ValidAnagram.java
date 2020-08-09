public class ValidAnagram{
    /**
     * 题目描述：给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * 题目链接:https://leetcode-cn.com/problems/valid-anagram/
     * 使用哈希表
     * 1.比较s和t的字符出现的次数，由于大小写不敏感，所以开辟一个数组长度为26
     * 2.遍历两个字符串，s的字符就让数组相应的值++，t的字符就--，然后在t循环的同时判断当前数组的值是否小于零
     * 3.如果小于零说明t中有和s不同的字符或者有相同的字符比s多
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (char s1 : s.toCharArray()) {
            counter[s1-97]++;
        }
        for (char t1 : t.toCharArray()) {
            counter[t1-97]--;
            if (counter[t1-97] < 0){
                return false;
            }
        }
        return true;
    }
}