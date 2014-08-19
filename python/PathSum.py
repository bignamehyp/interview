class pathSum:
    def hasPathSum(self, root, sum):
        if root == None:return False
        
        if root.left == None and root.right == None:
            return root.val == sum
        return self.hasPathSum(root.left, sum-root.val) or self.hasPathSum(root.right, sum-root.val)
