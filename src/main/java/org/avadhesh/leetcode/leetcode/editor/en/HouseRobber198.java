/**
You are a professional robber planning to rob houses along a street. Each house 
has a certain amount of money stashed, the only constraint stopping you from 
robbing each of them is that adjacent houses have security systems connected and 
it will automatically contact the police if two adjacent houses were broken into 
on the same night. 

 Given an integer array nums representing the amount of money of each house, 
return the maximum amount of money you can rob tonight without alerting the police.
 

 
 Example 1: 

 
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
 

 Example 2: 

 
Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (
money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
 

 
 Constraints: 

 
 1 <= nums.length <= 100 
 0 <= nums[i] <= 400 
 

 Related Topics Array Dynamic Programming 👍 21834 👎 460

*/
  
  package org.avadhesh.leetcode.leetcode.editor.en;

import java.util.Arrays;

public class HouseRobber198{
      public static void main(String[] args) {
           Solution solution = new HouseRobber198().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
        class Solution {

          //1. Memoization: Top Down approach
          // TC: O(n). SC: O(n) + O(recursion stack height) = O(n)
          /*private int rob(int n, int[] nums, int[] dp) {
              if(n==1) return nums[n-1];
              if(n==0) return 0;

              if(dp[n] != -1) return dp[n];

              int pick = nums[n-1] + rob(n-2, nums, dp);
              int notPick = rob(n-1, nums, dp);

              return dp[n*//**//*] = Math.max(pick, notPick);
          }

          public int rob(int[] nums) {
              int size = nums.length;
              int[] dp = new int[size+1];
              Arrays.fill(dp,-1);

              return rob(size, nums, dp);

          }*/



          /*
          Approach2: Tabulation: top down 1D dp
          TC: O(n). SC: O(n)
          public int rob(int[] nums) {
              int size = nums.length;
              int[] dp = new int[size+1];
              Arrays.fill(dp,0);
              dp[1] = nums[0];
              for(int i=2; i<=size; i++) {
                  int pick = nums[i-1] + dp[i-2];
                  int notPick = dp[i-1];
                  dp[i] = Math.max(pick, notPick);
              }

              return dp[size];
          }*/


          /*
          Approach3: Tabulation: top down  dp
          TC: O(n). SC: O(1)
          */
          public int rob(int[] nums) {
              int size = nums.length;
              int prev1=0, prev2 = nums[0];
              int ans = nums[0];
              for(int i=2; i<=size; i++) {
                  int pick = nums[i-1] + prev1;
                  int notPick = prev2;
                  ans = Math.max(pick, notPick);
                  prev1 = prev2;
                  prev2 = ans;
              }

              return ans;
          }
        }
//leetcode submit region end(Prohibit modification and deletion)

  }