class Solution:
    # @param root, a tree node
    # @return an integer
    def maxPathSum(self, root):
        if root == None:
            return 0
        self.maxSum = root.val
        self.find(root)
        return self.maxSum
        
    def find(self, root):
        if root == None:
            return 0
        lval = self.find(root.left)
        rval = self.find(root.right)
        cval = root.val
        if lval > 0:
            cval += lval
        if rval > 0:
            cval += rval
        self.maxSum = max(self.maxSum, cval)
        return max(root.val, max(lval,rval) + root.val)
        