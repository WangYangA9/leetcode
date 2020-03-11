class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Solution {
    //解法1 迭代
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode p = head;

        while(m > 1){
            pre = p;
            p = p.next;
            m--;
            n--;
        }
        ListNode entry = pre, tail = p;
        while(n > 0){
            ListNode temp = p.next;
            p.next = pre;
            pre = p;
            p = temp;
            n--;
        }
        if(entry != null){
            entry.next = pre;
        } else {
            head = pre;
        }
        tail.next = p;
        return head;
    }
}
