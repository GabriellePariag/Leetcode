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

        while (!(l1 == null) && !(l2 == null)) {
            ListNode node = new ListNode();
            while(flag) {
                ref = node;
                flag = false;
            }
            if(!(prev == null)) prev.next = node;

            sum = l1.val + l2.val + carry;
            System.out.println("sum is: " + sum);

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
            l1 = l1.next;
            l2 = l2.next;
        }

        // if l1 is trailing, add the remaining digits
        while (!(l1 == null)) {
            sum = l1.val + carry;
            ListNode node = new ListNode();
            if(!(prev == null)) prev.next = node;

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
            l1 = l1.next;
        }

        // if l2 is trailing, add the remaining digits
        while (!(l2 == null)) {
            sum = l2.val + carry;
            ListNode node = new ListNode();
            if(!(prev == null)) prev.next = node;

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
            l2 = l2.next;
        }

        if (carry > 0) {
            ListNode node = new ListNode(carry);
            if(!(prev == null)) prev.next = node;
        }

        return ref;
    }
}
/*
5 and 2 = 7. 7 < 10 check, return 7
4 and 6 = 10. 10 < 10 false, return 10-10 = return 0. carry the one.
3 and 4 = 7. add the carry 7+1 = 8. 8 < 10 check, return 8.

2 4 3 4
1 0 1

3 4 4 4

38
45
*/