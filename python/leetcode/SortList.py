class SortList:
    def sortList(self, head):
        if head is None or head.next is None:
            return head
        slow = head
        fast = head
        prev = None
        while fast and fast.next:
            prev = slow
            slow = slow.next
            fast = fast.next
            if fast:
                fast = fast.next
        prev.next = None
        l = self.sortList(head)
        r = self.sortList(slow)
        newHead = None
        node = None
        while l and r:
            if l.val < r.val:
                if newHead is None:
                    newHead = l
                else:
                    node.next = l
                node = l
                l = l.next
            else:
                if newHead is None:
                    newHead = r
                else:
                    node.next = r
                node = r
                r = r.next
        if l:
            node.next = l
        if r:
            node.next = r
        return newHead