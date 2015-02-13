# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class BSTIterator:
    # @param root, a binary search tree's root node
    def __init__(self, root):
        self.node = root
        
                
                
    # @return a boolean, whether we have a next smallest number
    def hasNext(self):
        return self.node
    # @return an integer, the next smallest number
    def next(self):
        v = 0
        while self.node:
            if self.node.left is None:
                v = self.node.val
                self.node = self.node.right
                break
            else:
                prev = self.node.left
                while prev.right and prev.right != self.node:
                    prev = prev.right
                if prev.right is None:
                    prev.right = self.node
                    self.node = self.node.left
                else:
                    prev.right = None
                    v = self.node.val
                    self.node = self.node.right
                    break
        return v

# Your BSTIterator will be called like this:
# i, v = BSTIterator(root), []
# while i.hasNext(): v.append(i.next())