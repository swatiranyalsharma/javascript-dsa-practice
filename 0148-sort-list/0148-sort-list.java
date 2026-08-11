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
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    public ListNode mergeSort(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode mid = findMiddle(head);
        ListNode B = mid.next;
        mid.next = null;
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(B);
        return mergSortedLists(left,right);
    }

    public ListNode findMiddle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast !=null && fast.next !=null && fast.next.next !=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode mergSortedLists(ListNode A, ListNode B){
        ListNode p1 = A;
        ListNode p2 = B;
        ListNode prev = new ListNode(-1);
        ListNode dummy = prev;
        while(p1 !=null && p2 !=null){
            if(p1.val < p2.val){
                prev.next = p1;
                p1 = p1.next;
            }else{
                prev.next = p2;
                p2 = p2.next;
            }
            prev = prev.next;
        }
        if(p1 !=null){
            prev.next = p1;
        }
        if(p2 !=null){
            prev.next = p2;
        }
        return dummy.next;
    }
}