"""
Definition of ListNode
class ListNode(object):

    def __init__(self, val, next=None):
        self.val = val
        self.next = next
"""
class Solution:
    """
    @param hashTable: A list of The first node of linked list
    @return: A list of The first node of linked list which have twice size
    """
    def rehashing(self, hashTable):
        # write your code here
        cap = len(hashTable) * 2
        newTable = [None for i in range(cap)]
        for head in hashTable:
            while head:
                key = head.val % cap
                node = ListNode(head.val)
                node.next = newTable[key]
                newTable[key] = node
                head = head.next
        for i in range(cap):
            newTable[i] = self.rev(newTable[i])
        return newTable
        
    def rev(self, head):
        if head is None or head.next is None:
            return head
        prev = head
        node = head.next
        prev.next = None
        while node:
            nextNode = node.next
            node.next = prev
            prev = node
            node = nextNode
        return prev
            