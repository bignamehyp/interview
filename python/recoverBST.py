class recoverBST:
    def recoverTree(self, root):
        node = root
        first = None
        second = None
        parent = None
        while node:
            if node.left:
                prev = node.left
                while prev.right and prev.right != node:
                    prev = prev.right
                if prev.right == None:
                    prev.right = node
                    node = node.left
                    continue
                if prev.right == node:
                    prev.right = None
                    if parent and parent.val > node.val:
                        if second:
                            second = node
                        else:
                            first = parent
                            second = node
                    parent = node
                    node = node.right
            else:
                if parent and parent.val > node.val:
                    if second:
                        second = node
                    else:
                        first = parent
                        second = node
                parent = node                
                node = node.right
        if first and second:
            tmp = first.val
            first.val = second.val
            second.val = tmp
            
        return root
                

                
                
        
