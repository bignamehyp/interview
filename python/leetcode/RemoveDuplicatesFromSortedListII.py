class RemoveDuplicatesFromSortedListII:
    def deleteDuplicates(self, head):
        if head == None or head.next == None:
            return head
        prev = None
        node = head
        newHead = None        
        while node:
            val = node.val
            if not node.next or node.next.val != val:
                if not prev:
                    newHead = node
                else:
                    prev.next = node
                prev = node
            else:
                while node.next and node.next.val == val:
                    node = node.next
                if prev:
                    prev.next = node.next
            node = node.next
        return newHead
        

            
                    