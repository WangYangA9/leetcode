/**
 * Created by Administrator on 2019/5/16 0016.
 */

import java.util.Arrays;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;
        if(lists.length == 1)
            return lists[0];
        if(lists.length == 2){
            return mergeTwoLists(lists[0],lists[1]);
        }
        int mid = lists.length / 2;

        return mergeTwoLists(mergeKLists(Arrays.copyOfRange(lists, 0, mid)), mergeKLists(Arrays.copyOfRange(lists, mid, lists.length)));
    }

    ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        ListNode head = null;
        if(l1.val < l2.val){
            head = l1;
            l1.next = mergeTwoLists(l1.next, l2);
        } else {
            head = l2;
            l2.next = mergeTwoLists(l1, l2.next);
        }
        return head;
    }
}