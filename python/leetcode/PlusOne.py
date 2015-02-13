class PlusOne:
    def PlusOne(self,digits):
        digits.reverse()
        carry = 1
        for i in range(len(digits)):
            d = digits[i]
            if d + carry >= 10:
                d = d + carry - 10
                carry = 1
            else:
                d = d + carry
                carry = 0
            digits[i] = d
        if carry > 0:
            digits.append(carry)
        return digits.reverse()
            
        