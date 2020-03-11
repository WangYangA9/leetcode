import java.util.LinkedList;
import java.util.Stack;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Solution {
    //方法1 迭代
//    public ListNode swapPairs(ListNode head) {
//        if(head == null){
//            return null;
//        }
//        if(head.next == null){
//            return head;
//        }
//        ListNode dummy = new ListNode(-1);
//        ListNode pre = dummy;
//        ListNode curr = head;
//
//        while(curr != null && curr.next != null){
//            ListNode temp1 = curr;
//            ListNode temp2 = curr.next;
//            curr = temp2.next;
//            pre.next = temp2;
//            temp2.next = temp1;
//            temp1.next = curr;
//            pre = temp1;
//        }
//        return dummy.next;
//    }
    //方法2 递归
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode temp1 = head;
        ListNode temp2 = head.next;
        ListNode result = swapPairs(temp2.next);
        temp1.next = result;
        temp2.next = temp1;
        return temp2;
    }
    //晋级 k个一组翻转
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode p = head;
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while(p != null){
            Stack<ListNode> stack = new Stack<>();
            int i = 0;
            for(i = 0; i < k && p != null; i++) {
                stack.push(p);
                p = p.next;
            }
            while(!stack.empty()){
                pre.next = stack.pop();
                pre = pre.next;
            }
        }
        pre.next = null;
        return dummy.next;
    }
    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        reverseKGroup(l1, 3);

    }
}
