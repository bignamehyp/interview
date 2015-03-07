"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        this.val = val
        this.left, this.right = None, None
"""
class Solution:
    # @param A: Given an integer array with no duplicates.
    # @return: The root of max tree.
    def maxTree(self, A):
        # write your code here
        stack = []
        for a in A:
            node = TreeNode(a)
            if len(stack) > 0:
                lPeak = stack[-1]
                while len(stack) > 0 and stack[-1].val < a:
                    lPeak = stack.pop()
                if len(stack) == 0:
                    node.left = lPeak
                else:
                    node.left = stack[-1].right
                    stack[-1].right = node
            stack.append(node)
        return stack[0]
            