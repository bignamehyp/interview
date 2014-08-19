package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode slow = head, fast = head, prev = null;
        while (fast  != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (prev != null)prev.next = null;
        ListNode first = sortList(head);
        ListNode second = sortList(slow);
        return merge(first, second);
    }
    
    public ListNode merge(ListNode first, ListNode second){
        ListNode head = null, node = null;
        while( first != null || second != null){
            int v1 = Integer.MAX_VALUE;
            int v2 = Integer.MAX_VALUE;
            if (first != null)v1 = first.val;
            if (second != null) v2 = second.val;
            if( v1 < v2){
                if(head == null){
                    head = first;
                    node = first;
                }else{
                    node.next = first;
                    node = node.next;
                }
                first = first.next;
            }else{
                if(head == null){
                    head = second;
                    node = second;
                }else{
                    node.next = second;
                    node = node.next;
                }
                second = second.next;
            }
        }
        return head;
    }
}
