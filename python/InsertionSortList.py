class InsertionSortList:
    def InsertionSortList(self, head):
        if head == None or head.next == None:
            return head
        node = head.next
        prev = head
        newHead = head
        while node:
            tmp = newHead
            nextNode = node.next
            
            if tmp.val > node.val:
                node.next = newHead
                prev.next = nextNode
                newHead = node
            else:
                while tmp.next.val < node.val:
                    tmp = tmp.next
                if tmp.next != node:
                    node.next = tmp.next
                    tmp.next = node
                    prev.next = nextNode
                else:
                    prev = node
            node = nextNode
        return newHead
            
        