class pathSumII:
    def pathSum(self, root, sum):
        if not root:return []
        soln = [root.val]
        self.dfs(root, sum - root.val, soln,solns)
        return solns
        
    def dfs(self, root, sum, soln, solns):
        if root.left == None and root.right == None:
            if sum == 0:
                solns.append(soln)
            return
        if root.left:   
            self.dfs(root.left, sum - root.left.val, soln + [root.left], solns)
        if root.right:
            self.dfs(root.right, sum - root.right.val, soln + [root.right], solns)
 
    
