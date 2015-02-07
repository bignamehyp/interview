class DecodeWays:
    def numDecodings(self, s):      
        if len(s) == 0:
            return 0
        sum1 = 1    
        sum2 = 1 if s[0] != '0' else 0
        sum3 = sum2
        for i in range(1, len(s)):
            sum3 = 0
            if 10 <= int(s[i-1:i+1]) <= 26:
                sum3 += sum1
            if int(s[i]) != 0:
                sum3 += sum2
            sum1 = sum2
            sum2 = sum3
        return sum3    
        