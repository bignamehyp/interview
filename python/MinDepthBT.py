class MinDepthBT:
    def minDepth(self, root):
        if root == None:
            return 0
        stack = [root]
        children = []
        depth = 1
        while len(stack) > 0:
            node = stack.pop()
            if node.left == None and node.right == None:
                return depth
            if node.left:
                children.append(node.left)
            if node.right:
                children.append(node.right)
            if len(stack) == 0 and len(children) > 0:
                depth += 1
                stack = children
                children = []
        return depth         
