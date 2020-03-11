class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Solution {
    //方法一 头插法
//    public ListNode reverseList(ListNode head) {
//        ListNode pre = null;
//        ListNode p = head;
//        while(p != null){
//            ListNode next = p.next;
//            p.next = pre;
//            pre = p;
//            p = next;
//        }
//        return pre;
//    }
    //方法二 递归法
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
