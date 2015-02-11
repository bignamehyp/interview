class Solution:
    # @return a list of tree node
    def generateTrees(self, n):
        return self.helper(1, n)
        
    def helper(self, l, r):
        if l > r:
            return [None]
        if l == r:
            return [TreeNode(l)]
        list = []
        for t in range(l, r+1):
            for left in self.helper(l, t-1):
                for right in self.helper(t + 1, r):
                    node = TreeNode(t)
                    node.left = left
                    node.right = right
                    list.append(node)
        return list