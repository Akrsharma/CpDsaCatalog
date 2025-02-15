/**
You are a professional robber planning to rob houses along a street. Each house 
has a certain amount of money stashed. All houses at this place are arranged in 
a circle. That means the first house is the neighbor of the last one. Meanwhile,
 adjacent houses have a security system connected, and it will automatically 
contact the police if two adjacent houses were broken into on the same night. 

 Given an integer array nums representing the amount of money of each house, 
return the maximum amount of money you can rob tonight without alerting the police.
 

 
 Example 1: 

 
Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2)
, because they are adjacent houses.
 

 Example 2: 

 
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
 

 Example 3: 

 
Input: nums = [1,2,3]
Output: 3
 

 
 Constraints: 

 
 1 <= nums.length <= 100 
 0 <= nums[i] <= 1000 
 

 Related Topics Array Dynamic Programming 👍 10256 👎 169

*/
  
  package org.avadhesh.leetcode.leetcode.editor.en;

import java.util.Arrays;

public class HouseRobberIi213{
      public static void main(String[] args) {
           Solution solution = new HouseRobberIi213().new Solution();
          int[] nums = new int[] {200,3,140,20,10};
          int ans = solution.rob(nums);
          System.out.println(ans);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
          private int rob(int i, int[] nums, int[] dp) {
              if(i<0) return 0;
              if(i==0) {
                  return nums[i];
              }
              if(dp[i] != -1) return dp[i];
              int pick = nums[i] + rob(i-2, nums, dp);
              int notPick = rob(i-1, nums, dp);
              return dp[i] = Math.max(pick, notPick);
          }

          public int rob(int[] nums) {
              int size = nums.length;
              if(size == 1) return nums[0];
              int[] dp = new int[size];
              Arrays.fill(dp, -1);
              int withFirst = rob(size-2, Arrays.copyOf(nums, size-1), dp);
              Arrays.fill(dp, -1);
              int withoutFirst = rob(size-2, Arrays.copyOfRange(nums, 1, size), dp);

              return Math.max(withFirst, withoutFirst);
          }
    }
//leetcode submit region end(Prohibit modification and deletion)

  }