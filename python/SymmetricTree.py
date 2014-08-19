class SymmetricTree:
 
    def mirrorTree(self, root):
        if root is None: return None
        newRoot = TreeNode(root.val)
        newRoot.left = self.mirrorTree(root.right)
        newRoot.right = self.mirrorTree(root.left)
        return newRoot
        
    def isSameTree(self, r1, r2):
        if r1 is None and r2 is None:
            return True
        if r1 is not None and r2 is not None:
            return r1.val == r2.val and self.isSameTree(r1.left,r2.left) and self.isSameTree(r1.right, r2.right)
        else:
            return False

    def isSymmetric(self, root):
        r2 = self.mirrorTree(root)
        return self.isSameTree(root, r2)