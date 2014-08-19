class ValidBST:
    def isValid(self, root, minVal, maxVal):
        if root == None:
            return True
        if not minVal < root.val < maxVal:
            return  False
        return self.isValid(root.left, minVal, root.val) and self.isValid(root.right, root.val, maxVal)    
            
        
    def isValidBST(self, root):
        return self.isValid(root, float('-Inf'), float('Inf'));
        
