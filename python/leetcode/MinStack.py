class MinStack:
    def __init__(self):
        self.stack = []
        self.minStack = []
    # @param x, an integer
    # @return an integer
    def push(self, x):
        self.stack.append(x)
        if len(self.minStack) == 0 or x <= self.minStack[-1]:
            self.minStack.append(x)
        
    # @return nothing
    def pop(self):
        x = self.stack.pop()
        if len(self.minStack) > 0 and x == self.minStack[-1]:
            self.minStack.pop()
            
    # @return an integer
    def top(self):
        if len(self.stack):
            return self.stack[-1]
        else:
            return -1

    # @return an integer
    def getMin(self):
        if len(self.minStack) > 0:
            return self.minStack[-1]
        else:
            return -1