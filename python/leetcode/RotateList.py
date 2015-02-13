class RotateList:
     def rotateRight(self, head, k):
        if head == None or head.next == None:
            return head
        len = 1
        node = head
        while node.next:
            node = node.next
            len += 1
        k = k % len
        if k == 0:
            return head
        node.next = head
        i = 0
        while i < len - k:
            node = node.next
            i += 1
        newhead = node.next
        node.next = None
        return newhead