# [岛屿的最大面积](https://leetcode-cn.com/problems/max-area-of-island/)

给你一个大小为 m x n 的二进制矩阵 grid 。

岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。

岛屿的面积是岛上值为 1 的单元格的数目。

计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。

## 深度优先搜索

 ```go
 func maxAreaOfIsland(grid [][]int) int {
     max := func (a, b int) int {
         if a > b {
             return a
         }else {
             return b
         }
     }
     ans := 0
     n, m := len(grid), len(grid[0])
     for i := 0; i < n; i++ {
         for j := 0; j < m; j++ {
             if grid[i][j] == 1 {
                 ans = max(ans, area(grid, i, j))
             }
         }
     }
     return ans
 }
 
 func area(grid [][]int, x, y int) int {
     grid[x][y] = 0
     n, m := len(grid), len(grid[0])
     a := 1
     if x > 0 && grid[x-1][y] == 1 {
         a += area(grid, x-1, y)
     }
     if x < n - 1 && grid[x+1][y] == 1 {
         a += area(grid, x+1, y)
     }
     if y > 0 && grid[x][y-1] == 1 {
         a += area(grid, x, y-1)
     }
     if y < m - 1 && grid[x][y+1] == 1 {
         a += area(grid, x, y+1)
     }
     return a
 }
 ```

##  广度优先搜索

```java
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    ans = Math.max(area(grid, i, j), ans);
                }
            }
        }
        return ans;
    }
    int area(int[][] grid, int xx, int yy) {
        int area = 0;
        Deque<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(xx, yy));
        int m = grid.length, n = grid[0].length;
        grid[xx][yy] = 0;
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            area++;
            int x = p.x, y = p.y;
            if (x > 0 && grid[x-1][y] == 1) {
                queue.offer(new Pair(x-1, y));
                grid[x-1][y] = 0;
            }
            if (x < m - 1 && grid[x+1][y] == 1) {
                queue.offer(new Pair(x+1, y));
                grid[x+1][y] = 0;
            }
            if (y > 0 && grid[x][y-1] == 1) {
                queue.offer(new Pair(x, y - 1));
                grid[x][y-1] = 0;
            }
            if (y < n - 1 && grid[x][y+1] == 1) {
                queue.offer(new Pair(x, y + 1));
                grid[x][y+1] = 0;
            }
        }
        return area;
    }
    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
```



来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/max-area-of-island
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

