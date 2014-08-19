class SortList:
    def sortList(self, head):
        if head == None or head.next == None:return head
        fast = head
        slow = head
        prev = None
        while fast and fast.next:
            fast = fast.next.next            
            prev = slow                
            slow = slow.next
        if prev:
            prev.next = None
        first = self.sortList(head)
        second = self.sortList(slow)
        newHead = self.merge(first, second)
        return newHead
        
    def merge(self, first, second):
        head = None
        node = None
        while first or second:
            v1 = 1 << 32
            v2 = 1 << 32
            if first:
                v1 = first.val
            if second:
                v2 = second.val
            if v1 < v2:
                if not head:
                    head = first
                    node = first
                else:
                    node.next = first
                    node = node.next
                first = first.next
            else:
                if not head:
                    head = second
                    node = second
                else:
                    node.next = second
                    node = node.next
                second = second.next
        return head
            
                    
        