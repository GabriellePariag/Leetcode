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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = null;
        ListNode ref = new ListNode();
        boolean flag = true;
        int v1, v2, sum;
        int carry = 0;

        while (!(l1 == null) || !(l2 == null)) {
            ListNode node = new ListNode();
            // flag checks if we've set our reference (head) for the return result
            while(flag) {
                ref = node;
                flag = false;
            }
            // if we are not on the first node, start setting the arrows
            if(!(prev == null)) prev.next = node;

            // check for any leading linked lists
            if(!(l1 == null) && (l2 == null)){
                sum = l1.val + carry;
                l1 = l1.next;
            }
            else if (!(l2 == null) && (l1 == null)) {
                sum = l2.val + carry;
                l2 = l2.next;
            }
            // if they both still have two digits, find sum of all digits
            else {
                sum = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            }

            // calculate final node value using carry value (like manual addition)
            if(sum < 10) {
                node.val = sum;
                carry = 0;
            }
            else if(sum == 10) {
                node.val = 0;
                carry = 1;
            }
            else {
                node.val = sum%10;
                carry = (10%sum)/10;
            }

            // add the node to the list
            prev = node;
        }

        // if there are any remaining digits to be carried, add them to the list
        if (carry > 0) {
            ListNode node = new ListNode(carry);
            if(!(prev == null)) prev.next = node;
        }

        // return the reference head we made earlier
        return ref;
    }
}