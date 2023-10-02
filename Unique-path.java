/*
-----------Problem Statement-------------
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]).
The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
The test cases are generated so that the answer will be less than or equal to 2 * 109.

-----------Intuition-----------
The intuition behind this solution is that we can use dynamic programming to find the number of unique paths that the robot 
can take to reach the bottom-right corner. We can maintain a 2D array dp of size m x n, where m is the number of rows in the 
grid and n is the number of columns in the grid. Each element dp[i][j] will represent the number of unique paths that the 
robot can take to reach the cell (i, j).

-------------Approach---------------
The approach is to start from the top-left corner of the grid and work our way down and to the right. 
For each cell (i, j), we consider two cases:
        -The robot can reach the cell (i, j) from the cell above it. In this case, the number of unique paths to reach (i, j) is 
        equal to the number of unique paths to reach the cell above it.
        -The robot can reach the cell (i, j) from the cell to the left of it. In this case, the number of unique paths to reach (i, j) is 
        equal to the number of unique paths to reach the cell to the left of it.
We then combine these two cases to get the total number of unique paths to reach the cell (i, j).

Finally, we return the value of dp[m - 1][n - 1], which will be the number of unique paths that the robot can take to reach the 
bottom-right corner of the grid.

-----------Complexity--------------
Time complexity: O(m * n), since we need to visit each cell in the grid once.
Space complexity: O(m * n), since we need to maintain the 2D array dp.
-----------Code---------------
*/
class Solution {
    public int uniquePaths(int m, int n) {
        int [][] dp = new int [m][n];

    //first we will be filling first row as we know all will be having 1 path only
        for(int i=0;i<dp[0].length;i++){
            dp[0][i] = 1; //row 0 and col will be changing 
        }

        for(int i=0;i<dp.length;i++){
            dp[i][0] = 1; //col 0 and row will be changing 
        }
    //now will be start filling 2nd row 
    //how :- summing --> ek row pehle nd ek col piche
        for(int i = 1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
    return dp[m-1][n-1];  
    }
}

// 1  1  1  1  1  1  1 
// 1  2  3  4  5  6  7
// 1  3  9  10 15 21 28
