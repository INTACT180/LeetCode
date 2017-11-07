
 //Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode outputHead = ListNode(l1.val + l2.val);
        ListNode outputTail = outputHead;
        ListNode temp;
        
        l1 = l1.next;
        l2 = l2.next;
        
        while(l1 != null && l2 != null)
        {
            temp = new ListNode(l1.val + l2.val);
            outputTail.next = temp;
            outputTail = temp;
            
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while(l1 != null)
        {
            temp = new ListNode(l1.val);
            outputTail.next = temp;
            outputTail = temp;
            l1 = l1.next;
        }
        
        while(l2 != null)
        {
            temp = new ListNode(l2.val);
            outputTail.next = temp;
            outputTail = temp;
            l2 = l2.next;
        }
        
        return outputHead;
    }
}