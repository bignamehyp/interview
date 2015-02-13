class LongestValidParentheses:
    # @param s, a string
    # @return an integer
    def longestValidParentheses(self, s):
        maxLength = 0
        lastValid = 0
        stack = []
        for i in range(len(s)):
            if s[i] == '(':
                stack.append(i)
            else:
                if stack:
                    stack.pop()
                    if stack:
                        start = stack[-1] + 1
                    else:
                        start = lastValid 
                    curLength = i - start + 1
                    if curLength > maxLength:
                        maxLength = curLength
                else:
                    lastValid = i + 1              
        return maxLength
        
