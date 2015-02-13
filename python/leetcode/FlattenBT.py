class FlattenBT:
    def flatten(self, root):
        stack = []
        while root:
            if root.right: 
                stack.append(root.right)
            if root.left: 
                root.right = root.left
                root.left = None
            else:
                if stack:
                    root.right = stack.pop()
            root = root.right
     
        
