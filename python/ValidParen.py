class ValidParen:
    def isValid(self,s):
        stack = []
        dict = {'(':')', '[':']', '{':'}'}
        for c in s:
            if c == '(' or c == '[' or c == '{':
                stack.append(dict[c])
            else:
                if len(stack) == 0 or c != stack.pop():
                    return False
        return len(stack) == 0
