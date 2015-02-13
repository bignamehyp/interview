# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param preorder, a list of integers
    # @param inorder, a list of integers
    # @return a tree node
    def buildTree(self, preorder, inorder):
        d = {}
        for i in range(len(inorder)):
            d[inorder[i]] = i
        return self.build(inorder, preorder, 0, len(inorder) - 1, 0, len(preorder) - 1, d)
        
    def build(self, inorder, preorder, inL, inR, postL, postR, d):
        if postL > postR:
            return None
        node = TreeNode(preorder[postL])
        idx = d[node.val] - inL
        node.left = self.build(inorder, preorder, inL, inL + idx - 1, postL + 1, postL + idx, d)
        node.right = self.build(inorder, preorder, inL + idx + 1, inR, postL + idx + 1, postR, d)
        return node