class TrapRainWater:
    def trap(self, A):
        area = 0
        prevH = 0
        l = 0
        r = len(A) - 1
        while l <= r:
            h = min(A[l],A[r])
            if h > prevH:
                area += (h - prevH) * (r - l + 1)
                prevH = h
            if A[l] < A[r]:
                area -= min( prevH, A[l] )
                l += 1
            else:
                area -= min( prevH, A[r] )
                r -= 1
        return area
        