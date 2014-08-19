class BTpreOder:
    def preorderTraversal(self, root):
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
                    soln.append(root.val)
                    root = root.left
                else:
                    prev.right = None
                    root = root.right
        return soln
        