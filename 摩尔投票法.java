//https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
/*
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
class Solution {
    public int majorityElement(int[] nums) {
        int vote = 0, x = nums[0];
        for(int n : nums){
            if (vote == 0){
                x = n;
            }
            if(x == n){
                vote++;
            }else{
                vote--;
            }
        }
        return x;
    }
}