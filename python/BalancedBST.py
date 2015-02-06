class BlancedBST:
    def isBalanced(self, root):
        if root is None:
            return True
        else:
            if self.isBalanced(root.left) and self.isBalanced(root.right):
                return abs(self.depth(root.left) - self.depth(root.right)) <= 1
            else:
                return False

    def depth(self, root):
        if root is None:
            return -1
        else:
            return max(self.depth(root.left), self.depth(root.right)) + 1