/* Problem Statement : 
Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), 
ans[i] is the number of 1's in the binary representation of i.

Example 1:

Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10
Example 2:

Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101

Intuition :
One way to count the number of 1's in the binary representation of a number is to 
iterate over all the bits in the number and check if each bit is set. If it is, then increment the count of 1's.

However, there is a more efficient way to do this using bitwise operations. 
Specifically, we can use the Integer.bitCount() method, which returns the number of 1 bits in the binary representation of an integer.

Approach :
Our approach is to use the Integer.bitCount() method to count the number of 1's in the binary representation of each number from 0 to n. 
We then store the results in an array and return the array.

Complexity :
Time complexity: O(n), since we need to iterate over all the numbers from 0 to n
Space complexity: O(n), since we need to store an array of size n+1. */

//Code : 
class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n+1];
        for (int i = 0; i <= n; i++) {
            result[i] = Integer.bitCount(i);
        }
        return result;
    }
}



