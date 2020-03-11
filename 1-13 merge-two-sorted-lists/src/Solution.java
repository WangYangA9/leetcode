
class Solution {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        ListNode ans = null;
        ListNode end = ans;
        while(l1 != null && l2 != null){
            ListNode temp = null;
            if(l1.val < l2.val){
                temp = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                temp = new ListNode(l2.val);
                l2 = l2.next;
            }
            if(end == null){
                ans = temp;
            } else {
                end.next = temp;
            }
            end = temp;
        }
        if(l1 != null){
            end.next = l1;
        }
        if(l2 != null){
            end.next = l2;
        }
        return ans;
    }
}