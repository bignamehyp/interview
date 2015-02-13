class RemoveDuplicatesFromSortedList:
    def deleteDuplicates(self, head):
        if head == None or head.next == None:
            return head
        node = head
        while node:
            val = node.val
            dup = node.next
            while dup and dup.val == val:
                dup = dup.next
            node.next = dup
            node = dup
            
        return head
        

            
                    