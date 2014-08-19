class BTInorder:
    def inorderTraversal(self, root):
        soln = []
        while root:
            if root.left == None:
                soln.append(root.val)
                root = root.right
            else:
                prev = root.left
                while prev.right != None and prev.right != root:
                    prev = prev.right
                if prev.right == None:
                    prev.right = root
                    root = root.left                    
                else:
                    soln.append(root.val)
                    root = root.right
                    prev.right = None
        return soln