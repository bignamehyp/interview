class ZigzagLevelOrder:
    def zigzagLevelOrder(self, root):
        l2r = True
        solns = []
        soln = []
        queue = collections.deque()
        if root == None:return solns
        queue.append(root)
        queue.append(None)
        while queue:
            node = queue.popleft()
            if node == None:
                if l2r:
                    solns.append(soln)
                else:
                    solns.append(soln[::-1])
                l2r = not l2r
                soln = []
                if queue:queue.append(None)
            else:
                if node.left:queue.append(node.left)
                if node.right:queue.append(node.right)
                soln.append(node.val)
        return solns
