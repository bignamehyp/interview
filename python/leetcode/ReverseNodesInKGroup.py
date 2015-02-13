# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param head, a ListNode
    # @param k, an integer
    # @return a ListNode
    def reverseKGroup(self, head, k):
        if k == 1 or head is None or head.next is None:
            return head
            
        step = 1
        node = head
        while step < k:
            node = node.next
            step = step + 1
            if node is None:
                return head
        newHead = node
        prev = head
        node = head.next
        prev.next = None
        step = 1
        while step < k:
            future = node.next
            node.next = prev
            prev = node
            node = future
            step += 1
        head.next = self.reverseKGroup(node, k)
        return newHead
    
