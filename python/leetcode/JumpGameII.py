class JumpGameII:
    def jump(self, A):
        maxPos = A[0]
        if len(A) == 1:return 0
        if maxPos >= len(A) - 1: return 1
        jumps = 1
        prev = maxPos
        pos = 1
        while pos <= prev:
            curJump = pos + A[pos]
            if curJump > maxPos:
                 maxPos = curJump
            if maxPos >= len(A) - 1:return jumps + 1
            if pos == prev:
                jumps += 1
                prev = maxPos                
            pos += 1
        return -1
        