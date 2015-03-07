"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        this.val = val
        this.left, this.right = None, None
"""
class Solution:
    '''
    @param root: An object of TreeNode, denote the root of the binary tree.
    This method will be invoked first, you should design your own algorithm 
    to serialize a binary tree which denote by a root node to a string which
    can be easily deserialized by your own "deserialize" method later.
    '''
    def serialize(self, root):
        # write your code here, using pre-order travelsal
        list = []
        self.preorder(root, list)
        return ','.join(list)
        
    def preorder(self, root, list):
        if root is None:
            list.append('#')
            return
        list.append(str(root.val))
        self.preorder(root.left, list)
        self.preorder(root.right, list)
        
    '''
    @param data: A string serialized by your serialize method.
    This method will be invoked second, the argument data is what exactly
    you serialized at method "serialize", that means the data is not given by
    system, it's given by your own serialize method. So the format of data is
    designed by yourself, and deserialize it here as you serialize it in 
    "serialize" method.
    '''
    def deserialize(self, data):
        # write your code here
        list = data.split(',')
        list.reverse()
        return self.decode(list)
            
    def decode(self, list):
        if len(list) == 0:
            return None
        if list[-1] == '#':
            list.pop()
            return None
        node = TreeNode(list[-1])
        list.pop()
        node.left = self.decode(list)
        node.right = self.decode(list)        
        return node
        
        