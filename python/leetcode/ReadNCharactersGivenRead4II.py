"""
The API: int read4(char *buf) reads 4 characters at a time from a file.
The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
"""

class Solution:
    def __init__(self):
        self.queue = []
    
        # @param buf, Destination buffer (a list of characters)
        # @param n,   Maximum number of characters to read (an integer)
        # @return     The number of characters read (an integer)

    def read(self, buf, n):
        idx = 0
        while True:
            buf4 = [""]*4
            l = read4(buf4)
            self.queue.extend(buf4)
            curr = min(len(self.queue), n-idx)
            for i in xrange(curr):
                buf[idx] = self.queue.pop(0)
                idx+=1
                if curr == 0:
                    break 
        return idx