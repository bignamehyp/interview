class SortedArrayToBST:
    def sortedArrayToBST(self, num):
        if num == None or len(num) == 0:return None
        mid = (len(num) - 1)/2
        node = TreeNode(num[mid])
        node.left = self.sortedArrayToBST(num[0:mid])
        node.right = self.sortedArrayToBST(num[mid+1:])
        return node
