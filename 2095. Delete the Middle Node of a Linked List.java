/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next==null)
        return null;
        
        ListNode fast, slow;
        fast = slow = head;
        ListNode prev = slow;
        int count=0;
        while(fast !=null  && fast.next != null){
            prev=slow;
            fast=fast.next.next;
            slow = slow.next;
        }
        prev.next= slow.next;
        return head;
    }
}
