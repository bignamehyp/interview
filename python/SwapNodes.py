class SwapNodes:
    def swapPairs(self, head):
        if not head or not head.next:
            return head
        first = head
        second = head.next
        prev = None
        newHead = head
        
        while first and second:
            nextNode = second.next
            second.next = first
            first.next = nextNode
            if not prev:
                newHead = second
            else:
                prev.next = second
            prev = first
            prev.next = nextNode
            first = nextNode
            if first:
                second = first.next
            else:
                second = None
        return newHead