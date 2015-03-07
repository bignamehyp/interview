class Queue:

    def __init__(self):
        self.stack1 = []
        self.stack2 = []
        
    def push(self, element):
        # write your code here
        self.stack1.append(element)
        
    def top(self):
        # write your code here
        # return the top element
        val = self.pop()
        self.stack2.append(val)
        return val
        
    def pop(self):
        # write your code here
        # pop and return the top element
        if len(self.stack2) == 0:
            while self.stack1:
                self.stack2.append(self.stack1.pop())
        if len(self.stack2) == 0:
            return None
        else:
            val = self.stack2.pop()
            return val
