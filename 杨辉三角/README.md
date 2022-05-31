# 杨辉三角

给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。

在「杨辉三角」中，每个数是它左上方和右上方的数的和。

![gif](https://pic.leetcode.cn/1626927345-DZmfxB-PascalTriangleAnimated2.gif)

示例 1:

输入: numRows = 5
输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
示例 2:

输入: numRows = 1
输出: [[1]]

```java
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            List<Integer> l = new ArrayList<>(i + 1);
            ans.add(l);
            if (i == 0) {
                l.add(1);
                continue;
            }
            List<Integer> prev = ans.get(i-1);
            for (int j = 0; j < i + 1; j++) {
                int a = 0, b = 0;
                if (j > 0) {
                    a = prev.get(j-1);
                }
                if (j < i) {
                    b = prev.get(j);
                }
                l.add(a + b);
            }
        }
        return ans;
    }
}
```

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/pascals-triangle
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。