# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param head, a ListNode
    # @return nothing
    def reorderList(self, head):
        if head is None or head.next is None or head.next.next is None:
            return head
        slow = head
        fast = head
        prev = None
        while fast:
            prev = slow
            slow = slow.next
            fast = fast.next
            if fast:
                fast = fast.next
        if prev:
            prev.next = None

        fast = slow.next
        slow.next = None
        while fast:
            futher = fast.next
            fast.next = slow
            slow = fast
            fast = futher
        
        fast = head
        while fast and slow:
            futher1 = fast.next
            futher2 = slow.next
            fast.next = slow
            slow.next = futher1
            fast = futher1
            slow = futher2