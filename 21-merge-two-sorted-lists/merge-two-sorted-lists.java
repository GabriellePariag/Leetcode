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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode();
        ListNode head = result;
        boolean thereIsNext = true;

        if((list1 == null) && (list2 == null)) return null;
        
        while(!(list1 == null) || !(list2 == null)) {
            System.out.println("going again");
            ListNode temp =  new ListNode();

            if (!(list1 == null) && (list2 == null)) {
                System.out.println("list 1 still got some");
                result.val = list1.val;
                list1 = list1.next;
                if(!(list1 == null)) {
                    result.next = new ListNode();
                    result = result.next;
                }
            }
            else if (!(list2 == null) && (list1 == null)) {
                System.out.println("list 2 still got some");
                result.val = list2.val;
                list2 = list2.next;
                if(!(list2 == null)) {
                    result.next = new ListNode();
                    result = result.next;
                }
            }
            
            else if(list1.val > list2.val) {
                result.val = list2.val;
                list2 = list2.next;
                result.next = new ListNode();
                result = result.next;
            }
            else if (list2.val > list1.val) {
                System.out.println(list1.val + " " + list2.val);
                result.val = list1.val;
                list1 = list1.next;
                result.next = new ListNode();
                result = result.next;
            }
            else if (list1.val == list2.val) {
                System.out.println(list1.val + " " + list2.val);
                result.val = list1.val;
                list1 = list1.next;
                result.next = new ListNode();
                result = result.next;

                result.val = list2.val;
                if(!(list1 == null) && !(list2 == null)) {
                    result.next = new ListNode();
                    result = result.next;
                    list2 = list2.next;
                }
            }
        }

        return head;
    }
}