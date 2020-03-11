class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) {
            return null;
        }

        int count = 0;
        ListNode p = head;
        ListNode pre = null;
        while(p != null){
            count++;
            pre = p;
            p = p.next;
        }
        if(k % count == 0){
            return head;
        }
        ListNode end = pre;
        int move = count - (k % count);
        pre = null;
        p = head;
        for(int i = 0; i < move; i++){
            pre = p;
            p = p.next;
        }
        end.next = head;
        pre.next = null;
        return p;
    }
}