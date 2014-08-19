class RemoveNthNode:
    def removeNthFromEnd(self, head,n):
        fast = head
        for i in range(1,n):
            fast = fast.next
        prev = None
        node = head
        while fast.next:
            prev = node
            node = node.next
            fast = fast.next
        if prev == None:
            return head.next
        prev.next = node.next
        node.next = None
        return head
