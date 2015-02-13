# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @return a ListNode
    def addTwoNumbers(self, l1, l2):
        carry = 0
        head = None
        node = head
        while l1 or l2:
            v1 = 0
            if l1:
                v1 = l1.val
                l1 = l1.next
            v2 = 0
            if l2:
                v2 = l2.val
                l2 = l2.next
            v = v1 + v2 + carry
            if v >= 10:
                v -= 10
                carry = 1
            else:
                carry = 0
            if head is None:
                head = ListNode(v)
                node = head
            else:
                node.next = ListNode(v)
                node = node.next
        if carry > 0:
            node.next = ListNode(carry)
        return head