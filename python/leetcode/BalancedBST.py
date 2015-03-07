def isBalanced(self, root):
    # write your code here
    height = self.height(root)
    return height >= 0        

def height(self, root):
    if root == None:
        return 0
    lh = self.height(root.left)
    rh = self.height(root.right)
    if lh >= 0 and rh >= 0 and abs(lh - rh) <= 1:
            return max(lh, rh) +  1
    else:
        return -1
