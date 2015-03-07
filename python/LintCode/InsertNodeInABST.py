"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        this.val = val
        this.left, this.right = None, None
"""
class Solution:
    """
    @param root: The root of the binary search tree.
    @param node: insert this node into the binary search tree.
    @return: The root of the new binary search tree.
    """
    def insertNode(self, root, node):
        if root is None:
            return node
        temp = root
        while temp:
            if node.val <= temp.val:
                if temp.left is None:
                    temp.left = node
                    break
                else:
                    temp = temp.left
            else:
                if temp.right is None:
                    temp.right = node
                    break
                else:
                    temp = temp.right
        return root