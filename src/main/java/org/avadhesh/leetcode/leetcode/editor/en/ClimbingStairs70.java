/**
You are climbing a staircase. It takes n steps to reach the top. 

 Each time you can either climb 1 or 2 steps. In how many distinct ways can you 
climb to the top? 

 
 Example 1: 

 
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
 

 Example 2: 

 
Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 

 
 Constraints: 

 
 1 <= n <= 45 
 

 Related Topics Math Dynamic Programming Memoization 👍 22795 👎 924

*/
  
  package org.avadhesh.leetcode.leetcode.editor.en;

import java.util.Arrays;

public class ClimbingStairs70{
      public static void main(String[] args) {
           Solution solution = new ClimbingStairs70().new Solution();
          System.out.println(solution.climbStairs(5));

      }
      //leetcode submit region begin(Prohibit modification and deletion)
        class Solution {
          // 1. Memoization: Top Down approach
          // TC O(n), SC O(n) + O(stack height)
          /*private int climbStairsRecur(int n, int []dp) {
              if(n<0) return 0;
              if(n == 0 || n == 1) return 1;
              if(dp[n] != 0) return dp[n];
              return dp[n] = climbStairsRecur(n-1, dp) + climbStairsRecur(n-2,dp);
          }
          public int climbStairs(int n) {
              int dp[] = new int[n+1];
              Arrays.fill(dp, 0);
              return climbStairsRecur(n, dp);

          }*/

          // 2. Tabular: 1D dp wihout space optimization
          // TC O(n), SC O(n)
          /*public int climbStairs(int n) {
              int[] dp = new int[n+1];
              Arrays.fill(dp, 0);
              dp[0] = 1; dp[1] = 1;
              for(int i=2; i<=n; i++)
                  dp[i] = dp[i-1] + dp[i-2];
              return dp[n];
          }*/


          // Tabulation: dp with space optimization
          // TC O(n), SC O(1)
          public int climbStairs(int n) {
              int prev1 = 1, prev2 = 1;
              int ans = prev1;
              for(int i=2; i<=n; i++){
                  ans = prev1 + prev2;
                  prev1 = prev2;
                  prev2 = ans;
              }
              return ans;
          }
        }
//leetcode submit region end(Prohibit modification and deletion)

  }