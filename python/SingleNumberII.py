class SingleNumber:
    def SingleNumber(self,A):
        one = 0
        two = 0
        for i in A:
            two |= one & i
            one ^= i
            three = two & one
            two &= ~three
            one &= ~three
        return one
        