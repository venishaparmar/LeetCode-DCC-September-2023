/*
-----------------Problem Statement-----------------
Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. 
Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.

-----------------Intuition----------------
We can use two pointers to detect a cycle in a linked list. The first pointer moves one node at a time, 
while the second pointer moves two nodes at a time. If the two pointers ever meet, then there is a cycle in the linked list.

------------------Approach------------------
Initialize two pointers, firstPtr and secondPtr, to the head of the linked list.
  -While firstPtr and secondPtr are not both null:
      -Move firstPtr forward one node.
      -Move secondPtr forward two nodes.
      -If firstPtr and secondPtr are ever equal, then there is a cycle in the linked list and the algorithm returns true.
If the algorithm reaches the end of the linked list without finding a cycle, then it returns false.

---------------Complexity-----------------

Time complexity: O(n)

Space complexity: O(1)

--------------------Code----------------
*/
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        //start a first and second pointer
        ListNode firstPtr = head;
        ListNode secondPtr = head;

        while(firstPtr != null && secondPtr != null && secondPtr.next != null)
        {
            //Advance both the poniter
            firstPtr = firstPtr.next;
            secondPtr = secondPtr.next.next;

            //If both pointer  meets then loop is there
            if(firstPtr == secondPtr){
                return true;
            }
        }

    return false;   
    }
}
