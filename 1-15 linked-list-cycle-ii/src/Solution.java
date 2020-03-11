class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Solution {
    public ListNode getIntersect(ListNode head){
        ListNode tortoise = head;
        ListNode hare = head;

        // A fast pointer will either loop around a cycle and meet the slow
        // pointer or reach the `null` at the end of a non-cyclic list.
        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
            if (tortoise == hare) {
                return tortoise;
            }
        }
        return null;

    }
    public ListNode detectCycle(ListNode head) {
        ListNode node = getIntersect(head);
        if (node == null){
            return null;
        }
        ListNode p = head;
        while(p != node){
            p = p.next;
            node = node.next;
        }
        return p;

    }
}