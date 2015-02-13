class RemoveNthNode:
     def removeNthFromEnd(self, head, n):
        if head == None or n == 0:
            return head
        i = 0
        fast = head
        while i < n:
            fast = fast.next
            i += 1
        slow = head
        if fast == None:
            return head.next
        while fast.next:
            slow = slow.next
            fast = fast.next
        slow.next = slow.next.next
        return head
    
