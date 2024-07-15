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
/*class Solution {
    public ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;

        while(curr != null){
            ListNode ahead = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ahead;
        }
        return prev;
        }

        public ListNode middle(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }

    public void reorderList(ListNode head) {
        if(head == null|| head.next == null) return;

        ListNode mid = middle(head);

        ListNode l1 = head;
        ListNode l2 = reverse(mid);

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while(l1 != null || l2 != null){
            if(l1!=null){
                tail.next = l1;
                tail = l1;
                l1 = l1.next;
            }
            if(l2!=null){
                tail.next = l2;
                tail = l2;
                l2 = l2.next;
            }
        }
        head = dummy.next;
    }
}
*/

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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){ //half the LL
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode prev = null; 

        while(temp != null){ //reverse second half
             ListNode n = temp.next;
             temp.next = prev;
             prev = temp;
             temp = n;
        }
        ListNode curr = head;
        while(prev != null){
            ListNode n = curr.next;
            curr.next = prev;
            prev = prev.next;
            curr.next.next = n;
            curr = n;
        }
    }
}
