class Solution:
    # @return an integer
    def maxArea(self, height):
        l = 0
        r = len(height) - 1
        area = 0
        while l < r:
            h = min(height[l], height[r])
            cur = h * (r - l)
            if cur > area:
                area = cur
            if height[l] < height[r]:
                while l < r and height[l] <= h:
                    l += 1
            else:
                while r > l and height[r] <= h:
                    r -= 1
        return area