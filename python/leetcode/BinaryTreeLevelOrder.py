class BTLevelOrder:
    def preorder(self, root, level, res):
        if root:
            if len(res) < level+1: res.append([])
            res[level].append(root.val)
            self.preorder(root.left, level+1, res)
            self.preorder(root.right, level+1, res)
            
    def levelOrder(self, root):
        res=[]
        self.preorder(root, 0, res)
        return res

    def levelOrderBottom(self, root):
        res=[]
        self.preorder(root, 0, res)
        res.reverse()
        return res 
                