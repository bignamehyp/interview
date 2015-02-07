class MergeTwoSortedList:
    def mergeTwoLists(self, l1, l2):
        head = None
        node = None
        while l1 != None or l2 != None:
            val1 = float('inf')
            val2 = float('inf')
            if l1 :
                val1 = l1.val
            if l2:
                val2 = l2.val
            if val1 < val2:
                if node == None:
                    node = l1
                    head = node
                else:
                    node.next = l1
                    node = node.next
                l1 = l1.next
            else:
                if node == None:
                    node = l2
                    head = node
                else:
                    node.next = l2
                    node = node.next
                l2 = l2.next
        return head
