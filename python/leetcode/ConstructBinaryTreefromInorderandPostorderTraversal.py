# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param inorder, a list of integers
    # @param postorder, a list of integers
    # @return a tree node
    def buildTree(self, inorder, postorder):
        d = {}
        for i in range(len(inorder)):
            d[inorder[i]] = i
        return self.build(inorder, postorder, 0, len(inorder) - 1, 0, len(postorder) - 1, d)
        
    def build(self, inorder, postorder, inL, inR, postL, postR, d):
        if postL > postR:
            return None
        node = TreeNode(postorder[postR])
        idx = d[node.val] - inL
        node.left = self.build(inorder, postorder, inL, inL + idx - 1, postL, postL + idx - 1, d)
        node.right = self.build(inorder, postorder, inL + idx + 1, inR, postL + idx, postR-1, d)
        return node