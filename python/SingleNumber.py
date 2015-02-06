class SingleNumber:
    def SingleNumber(self,A):
        one = 0
        for i in A:
            one ^= i             
        return one
        