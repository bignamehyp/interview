class DivTwoInt:
    def divide(self, dividend, divisor):
        if divisor == 1:return dividend
        sign = 1
        if dividend * divisor * 1.0 < 0:
            sign = -1
        dividend = abs(dividend) * 1.0
        divisor = abs(divisor) * 1.0
        if dividend < divisor: return 0
        ans = 0
        while dividend >= divisor:
            power = 1
            dis = divisor
            while dividend >= dis:
                dividend -= dis
                ans+=power
                power+=power
                dis+=dis
        return sign * ans
