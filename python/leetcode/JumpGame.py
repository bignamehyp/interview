class JumpGame:
    def canJump(self, A):
        maxPos = A[0]
        i = 1
        if maxPos >= len(A) - 1:return True
        
        while i <= maxPos:
            curJump = i + A[i]
            if curJump > maxPos:
                maxPos = curJump
            if maxPos >= len(A) - 1:
                return True
            i += 1
        return False    