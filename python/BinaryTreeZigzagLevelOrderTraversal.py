# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param root, a tree node
    # @return a list of lists of integers
    def zigzagLevelOrder(self, root):
        if root is None:
            return []
        solns = []
        nodeList = [root]
        level = 0
        while len(nodeList) > 0:
            nodeList2 = []
            soln = []
            for node in nodeList:
                if node.left:
                    nodeList2.append(node.left)
                if node.right:
                    nodeList2.append(node.right)
                soln.append(node.val)
            if level % 2 == 1:
                soln.reverse()
            level += 1
            solns.append(soln)
            nodeList = nodeList2
        return solns
