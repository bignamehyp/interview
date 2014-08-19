class CopyListWRandomPtr:
    def copyRandomList(self, head):
        node = head
        while node:
            nextNode = node.next
            node.next = RandomListNode(node.label)
            node.next.next = nextNode
            node = nextNode
        node = head
        while node:
            if node.random:
                node.next.random = node.random.next
            node = node.next.next
        node = head
        newHead = None
        copyNode = None
        while node:
            nextNode = node.next.next
            if not newHead:
                newHead = node.next
            else:
                copyNode.next = node.next
            copyNode = node.next            
            node.next = nextNode
            node = node.next
        return newHead
            
            
            