class SortedListToBST:
    def sortedListToBST(self, head):
        if head is None:
            return None
        if head.next is None:
            return TreeNode(head.val)
        slow = head
        fast = head
        prev = None
        while fast and fast.next:
            fast = fast.next.next
            prev = slow
            slow = slow.next
        if prev is not None:
            prev.next = None
        node = TreeNode(slow.val)
        node.left = self.sortedListToBST(head)
        node.right = self.sortedListToBST(slow.next)
        return node