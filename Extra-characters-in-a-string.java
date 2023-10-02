/*
Problem Statement:
You are given a 0-indexed string s and a dictionary of words dictionary. 
You have to break s into one or more non-overlapping substrings such that each substring is present in dictionary. 
There may be some extra characters in s which are not present in any of the substrings.
Return the minimum number of extra characters left over if you break up s optimally.
 
Example 1:
Input: s = "leetscode", dictionary = ["leet","code","leetcode"]
Output: 1
Explanation: We can break s in two substrings: "leet" from index 0 to 3 and "code" from index 5 to 8. 
There is only 1 unused character (at index 4), so we return 1.

Example 2:
Input: s = "sayhelloworld", dictionary = ["hello","world"]
Output: 3
Explanation: We can break s in two substrings: "hello" from index 3 to 7 and "world" from index 8 to 12. 
The characters at indices 0, 1, 2 are not used in any substring and thus are considered as extra characters. Hence, we return 3.

-------------Intuition-----------
The intuition behind this solution is that we can use dynamic programming to find the minimum number of extra characters left over if we break up s optimally. We can maintain an array dp of size n + 1, where n is the length of the input string s. Each element dp[i] will represent the minimum number of extra characters left over when processing the substring s[0:i].

-------------Approach------------
The approach is to start from the end of the string and work our way backwards. For each position i in the string, we consider two cases:

The substring s[0:i] is a word in the dictionary. In this case, the minimum number of extra characters left over is 0, since we can simply use this word as a substring.
The substring s[0:i] is not a word in the dictionary. In this case, the minimum number of extra characters left over is 1, since we will need to add at least one extra character to the beginning or end of the substring.
We then check all the words in the dictionary to see if any of them match the substring s[0:i]. If we find a match, then we update the value of dp[i] to be the minimum of the current value and the minimum number of extra characters left over when processing the substring s[i + length(word)].

Finally, we return the value of dp[0], which will be the minimum number of extra characters left over if we break up s optimally.

-----------Complexity------------
Time complexity: O(n * m), where n is the length of the input string s and m is the average length of a word in the dictionary. This is because we need to check all the words in the dictionary for each position i in the string.
Space complexity: O(n), since we need to maintain the array dp.

Code :
*/
import java.util.Arrays;

class Solution {
    private int[] dp = new int[51]; // Initialize dp array with 0 values

    public int minExtraChar(String s, String[] dictionary) {
        Arrays.fill(dp, -1); // Initialize dp array with -1 values
        return minExtraCharHelper(s, dictionary, 0);
    }

    private int minExtraCharHelper(String s, String[] dictionary, int i) {
        if (i == s.length()) {
            return 0;
        }

        if (dp[i] == -1) {
            dp[i] = 1 + minExtraCharHelper(s, dictionary, i + 1); // Initialize with one extra character

            for (String w : dictionary) {
                if (i + w.length() <= s.length() && s.substring(i, i + w.length()).equals(w)) {
                    dp[i] = Math.min(dp[i], minExtraCharHelper(s, dictionary, i + w.length())); // Update if a word in the dictionary is found
                }
            }
        }

        return dp[i]; // Return the minimum extra characters starting from position i
    }
}
