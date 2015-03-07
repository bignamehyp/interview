"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        this.val = val
        this.left, this.right = None, None
"""
import copy
class Solution:
    """
    @param root: The root of the binary search tree.
    @param A and B: two nodes in a Binary.
    @return: Return the least common ancestor(LCA) of the two nodes.
    """ 
    def lowestCommonAncestor(self, root, A, B):
        # write your code here
        if root is None:
            return None
        if root is not A and root is not B:
            foundA = self.lowestCommonAncestor(root.left, A, B)
            foundB = self.lowestCommonAncestor(root.right, A, B)
            if foundA and foundB:
                return root
            if foundA:
                return foundA
            if foundB:
                return foundB
        else:
            return root