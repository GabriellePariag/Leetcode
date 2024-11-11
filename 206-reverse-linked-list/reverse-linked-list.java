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
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode newNode = new ListNode(head.val);
        ListNode prev = newNode;
        
        while(!(head.next == null)) {
            newNode = new ListNode(head.next.val);
            newNode.next = prev;
            prev = newNode;
            head = head.next;
        }
        
        return prev;
    }
}