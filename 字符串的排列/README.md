#### [字符串的排列](https://leetcode-cn.com/problems/permutation-in-string/)

给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。

换句话说，s1 的排列之一是 s2 的 子串 。

示例 1：

```
输入：s1 = "ab" s2 = "eidbaooo"
输出：true
解释：s2 包含 s1 的排列之一 ("ba").
```

示例 2：

```
输入：s1= "ab" s2 = "eidboaoo"
输出：false
```

```java
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt = new int[26];
        int diff = 0;
        for (int i = 0; i < n; i++) {
            int ca = s1.charAt(i) - 'a';
            int cb = s2.charAt(i) - 'a';
            cnt[ca]--;
            cnt[cb]++;
        }
        for (int nn : cnt) {
            if (nn != 0) {
                diff++;
            }
        }
        if (diff == 0) {
            return true;
        }
        for (int i = n; i < m; i++) {
            int x = s2.charAt(i) - 'a';
            int y = s2.charAt(i - n) - 'a';
            if (x == y) {
                continue;
            }
            if (cnt[x] == 0) {
                diff++;
            }
            cnt[x]++;
            if (cnt[x] == 0) {
                diff--;
            }
            if (cnt[y] == 0) {
                diff++;
            }
            cnt[y]--;
            if (cnt[y] == 0) {
                diff--;
            }
            if (diff == 0) {
                return true;
            }
        }
        return false;
    }
}
```
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/permutation-in-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。