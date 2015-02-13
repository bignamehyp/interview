class BTPostOrder:
    def postorderTraversal(self, root):
        if root is None:
            return []
        stack = [root]
        soln = []
        while len(stack) > 0:
            node = stack[-1]
            if node.left is None and node.right is None:
                stack.pop()
                soln.append(node.val)
            elif node.left is not None:
                stack.append(node.left)
                node.left = None
            else:
                stack.append(node.right)
                node.right = None
        return soln
        
