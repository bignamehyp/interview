class RemoveElement:
    def removeElement(self, A, elem):
        pos = 0
        length = len(A)
        while pos < length:
            while pos < length and A[pos] == elem:
                A[pos] = A[length - 1]
                length -= 1
            pos += 1
        return length
        