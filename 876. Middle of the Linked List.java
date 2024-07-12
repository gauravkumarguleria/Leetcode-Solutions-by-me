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
    public ListNode middleNode(ListNode head) {
        ListNode curr = head;
        /*int count = 0;
        while(curr.next != null){
            curr = curr.next;
            count++;
        }
        curr = head;
        if(count%2==0) {for(int idx = 0; idx < count/2; idx++){
            curr = curr.next;
        }
        }
        else{
            for(int idx = 0; idx <= count/2; idx++){
            curr = curr.next;
        }
        }
        return curr;
        */
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }
}
