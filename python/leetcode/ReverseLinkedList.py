# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param head, a ListNode
    # @param m, an integer
    # @param n, an integer
    # @return a ListNode
    def reverseBetween(self, head, m, n):
        if head == None or m == n:
            return head
        prev = None
        slow = head
        i = 1
        while i < m:
            prev = slow
            slow = slow.next
            i += 1
        fastPrev = slow
        fast = slow.next
        while i < n and fast:
            fastNext = fast.next
            fast.next = fastPrev
            fastPrev = fast
            fast = fastNext
            i += 1
        slow.next = fast
        if prev:
            prev.next = fastPrev
        else:
            head = fastPrev
        return head