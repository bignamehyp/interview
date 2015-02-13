class LargestHist:
    def largestRectangleArea(self, height):
        height.append(0)
        stack = []
        maxVal = 0
        i = 0
        while i < len(height):
            if not stack or height[stack[len(stack)-1]] <= height[i]:
                stack.append(i)
                i+=1
            else:
                h = height[stack.pop()]
                if stack:
                    l = stack[len(stack)-1]
                else:
                    l = -1
                area = h  * ( i - l - 1)
                if area > maxVal:
                    maxVal = area
                
        return maxVal