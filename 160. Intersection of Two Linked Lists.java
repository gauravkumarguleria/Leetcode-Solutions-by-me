/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public int size(ListNode curr){
        int count=0;
        while(curr!=null){
            curr = curr.next;
            count++;
        }
        return count;
    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = size(headA);
        int sizeB = size(headB);

        ListNode currA = headA, currB = headB;

        for(int idx=0; idx< (sizeA-sizeB);idx++)
            currA = currA.next;
        for(int idx=0; idx< (sizeB-sizeA);idx++)
            currB = currB.next;


        while(currA != currB){
            currA =currA.next;
            currB = currB.next;
        }
        return currA;
    }
}
