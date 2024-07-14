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
    public ListNode middle(ListNode head){
        ListNode slow, fast;
        slow=fast=head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow= slow.next;
        }
        return slow;
    }
    
    public ListNode reverse(ListNode head){
        ListNode prev = null, curr = head;

        while(curr != null){
            ListNode ahead = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ahead;
        }
        return prev;
    }

    public boolean isPalindrome(ListNode first) {
        ListNode mid = middle(first);
        ListNode second = reverse(mid);
        while(first != null && second != null){
            if(first.val != second.val) return false;
            first = first.next;
            second =second.next;
        }
        return true;
    }
}
