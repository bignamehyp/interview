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
    @param value: Remove the node with given value.
    @return: The root of the binary search tree after removal.
    """    
    def removeNode(self, root, value):
        # write your code here
        if root is None:
            return None
        if root.val == value:
            if root.left:
                parent = root
                prev = root.left
                while prev.right != None:
                    parent = prev
                    prev = prev.right
                root.val = prev.val
                if parent is root:
                    root.left = prev.left
                else:
                    parent.right = prev.left
            else:
                return root.right
        elif root.val > value:
            root.left = self.removeNode(root.left, value)
        else:
            root.right = self.removeNode(root.right, value)
        return root
