class Solution:
    # @return a string
    def fractionToDecimal(self, numerator, denominator):
        sign = 1
        if numerator * denominator < 0:
            sign = -1
        numerator = abs(numerator)
        denominator = abs(denominator)
        ans = str(numerator / denominator)
        if sign == -1:
            ans = '-' + ans
        numerator = numerator % denominator
        if numerator > 0:
            ans += '.'
        dict = {}
        frac = ''
        i = 0
        while numerator > 0:
            if numerator in dict:
                idx = dict[numerator]
                frac = frac[:idx] + '(' + frac[idx:] + ')'
                break
            else:
                dict[numerator] = i
            numerator *= 10
            val = numerator / denominator
            numerator = numerator % denominator
            frac = frac + str(val)
            i += 1 
        return ans + frac