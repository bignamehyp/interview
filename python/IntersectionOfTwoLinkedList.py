# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param two ListNodes
    # @return the intersected ListNode
    def getIntersectionNode(self, headA, headB):
        l1 = self.getLength(headA)
        l2 = self.getLength(headB)
        if l1 == 0 or l2 == 0:
            return None
        nodeA, nodeB = headA, headB
    
        if l1 > l2:
            i = 0
            while i < l1 - l2:
                nodeA = nodeA.next
                i += 1
        else:
            i = 0
            while i < l2 - l1:
                nodeB = nodeB.next
                i += 1
        while nodeA and nodeB:
            if nodeA.val == nodeB.val:
                return nodeA
            nodeA = nodeA.next
            nodeB = nodeB.next
        return None
            
    def getLength(self, head):
        node = head
        i = 0
        while node:
            i +=1
            node = node.next
        return i