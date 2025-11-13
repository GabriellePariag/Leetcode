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
    public ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        return helper(head, head.next, head.next, null);
    }
    
    
    public ListNode helper(ListNode head, ListNode next, ListNode result, ListNode prev) {
        // perform swap
        head.next = next.next;
        next.next = head;
        
        // connect prev
        if(prev != null) prev.next = next;
        
        if (head.next == null || head.next.next == null) return result;
        
        helper(head.next, head.next.next, result, head);
        return result;
    }
    
}