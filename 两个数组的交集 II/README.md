# 两个数组的交集 II

给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。

示例 1：

输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2,2]
示例 2:

输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[4,9]

```java
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
       Arrays.sort(nums1);
       Arrays.sort(nums2);

       int i = 0, j = 0;
       List<Integer> l = new ArrayList<>();
       while (i < nums1.length && j < nums2.length) {
           if (nums1[i] == nums2[j]) {
               l.add(nums1[i]);
               i++;
               j++;
           }else if (nums1[i] < nums2[j]) {
               i++;
           }else {
               j++;
           }
       }
       int[] ans = new int[l.size()];
        for (i = 0; i < l.size(); i++) {
            ans[i] = l.get(i);
        }   
        return ans;
    }
}
```

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/intersection-of-two-arrays-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。