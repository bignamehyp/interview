# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param root, a tree node
    # @return an integer
    def sumNumbers(self, root):
        if root is None:
            return 0
        self.sum = 0
        self.dfs(root.val, root)
        return self.sum
    
    def dfs(self, value, root):
        if root.left is None and root.right is None:
            self.sum += value
        if root.left:
            self.dfs(value * 10 + root.left.val, root.left)
        if root.right:
            self.dfs(value * 10 + root.right.val, root.right)