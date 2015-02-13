class LinkedListCycleII:
    def detectCycles(self, head):
        if head == None or head.next == None:
            return None
        fast = head.next.next
        slow = head.next
        while slow != fast:
            if slow.next == None:return None
            slow = slow.next
            if fast.next == None or fast.next.next == None:return None
            fast = fast.next.next
        slow = head
        while slow != fast:
            slow = slow.next
            fast = fast.next
        return slow
        
