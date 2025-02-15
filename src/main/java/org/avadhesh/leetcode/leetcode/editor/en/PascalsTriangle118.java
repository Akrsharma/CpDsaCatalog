/**
Given an integer numRows, return the first numRows of Pascal's triangle. 

 In Pascal's triangle, each number is the sum of the two numbers directly above 
it as shown: 
 
 
 Example 1: 
 Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 
 Example 2: 
 Input: numRows = 1
Output: [[1]]
 
 
 Constraints: 

 
 1 <= numRows <= 30 
 

 Related Topics Array Dynamic Programming 👍 13491 👎 496

*/
  
  package org.avadhesh.leetcode.leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PascalsTriangle118{
      public static void main(String[] args) {
           Solution solution = new PascalsTriangle118().new Solution();
           List<List<Integer>> pascalTriangle = solution.generate(new Scanner(System.in).nextInt());
          System.out.println("answer");
      }
      //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

          public List<List<Integer>> generate(int numRows) {

              //Recursive solution
              /*if (numRows == 0) return new ArrayList<>();
              if (numRows == 1) {
                  List<List<Integer>> result = new ArrayList<>();
                  result.add(Arrays.asList(1));
                  return result;
              }

              List<List<Integer>> prevRows = generate(numRows-1);
              List<Integer> currRow = new ArrayList<>();
              currRow.add(1);
              for(int i=1; i<=numRows-2; i++) {
                  currRow.add(prevRows.getLast().get(i-1) + prevRows.getLast().get(i));
              }
              currRow.add(1);
              prevRows.add(currRow);
              return prevRows;*/



              //DP solution
              List<List<Integer>> pascalTriangle = new ArrayList<>();
              List<Integer> prevRow = new ArrayList<>();
              prevRow.add(1);
              pascalTriangle.add(prevRow);
              int i = 2;
              while(i<=numRows) {
                  List<Integer> row = new ArrayList<>();
                  row.add(1);
                  for(int j=1; j<=i-2; j++) {
                      row.add(prevRow.get(j-1) + prevRow.get(j));
                  }
                  row.add(1);
                  pascalTriangle.add(row);
                  prevRow = row;
                  i++;
              }
              return pascalTriangle;
          }
    }
    //leetcode submit region end(Prohibit modification and deletion)

  }