class NextPointerInBT:
    def connect(self, root):
        prev = None
        firstChild = None
        while root:
            if firstChild == None:
                if root.left: firstChild = root.left
                else: firstChild = root.right
            if root.left:
                if prev:
                    prev.next = root.left
                prev = root.left
            if root.right:
                if prev:
                    prev.next = root.right
                prev = root.right
            root = root.next
            if root == None:
                root = firstChild
                firstChild = None
                prev = None
            
