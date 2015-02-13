"""
The API: int read4(char *buf) reads 4 characters at a time from a file.
The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

Note:
The read function will only be called once for each test case
"""

class Solution:
    def read(self, buf, n):
        L = 4
        readBytes = 0
        start = 0
        while readBytes < n:
            sz = read4(buf[start:start + L-1])
            start += sz
            readBytes += sz
            if sz < 4:
                break
        return min(readBytes, n)