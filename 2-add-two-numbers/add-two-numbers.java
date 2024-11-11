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
            while(flag) {
                ref = node;
                flag = false;
            }
            if(!(prev == null)) prev.next = node;

            if(!(l1 == null) && (l2 == null)){
                sum = l1.val + carry;
                l1 = l1.next;
            }
            else if (!(l2 == null) && (l1 == null)) {
                sum = l2.val + carry;
                l2 = l2.next;
            }
            else {
                sum = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            }

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
                System.out.println("new node val is: " + node.val);
                System.out.println("carrying: " + carry);
            }

            prev = node;
        }

        if (carry > 0) {
            ListNode node = new ListNode(carry);
            if(!(prev == null)) prev.next = node;
        }

        return ref;
    }
}