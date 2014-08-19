class ReversePolish:
    def evalRPN(self, tokens):
        operants = []
        for token in tokens:
            if self.isNumber(token) :
                operants.append(int(token))
            else:
                num1 = 0
                num2 = 0
                if operants:
                    num2 = operants.pop()
                if operants:
                    num1 = operants.pop()
                operants.append( self.evaluate(token, num1, num2))
        return operants.pop()
        
    def evaluate(self, token, num1, num2):
        if token == '*':return num1 * num2
        if token == '/':return int(1.0 * num1 / num2)
        if token == '+':return num1 + num2
        if token == '-':return num1 - num2
        return 0
        
    def isNumber(self, s):
        if len(s) == 1 and (s[0] == '*' or s[0] == '/' or s[0] == '+' or s[0] == '-'):
            return False
        return True