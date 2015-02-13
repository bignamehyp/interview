class Atoi:
    def atoi(self, str):
        if len(str) == 0:
            return 0
        digit = {'0':0, '1':1,'2':2,'3':3,'4':4,'5':5,'6':6,'7':7,'8':8,'9':9}
        firstNonWhiteSpace = 0
        while str[firstNonWhiteSpace] == ' ':
            firstNonWhiteSpace += 1
        sign = 1
        if str[firstNonWhiteSpace] == '-':
            sign = -1
            firstNonWhiteSpace += 1
        elif str[firstNonWhiteSpace] == '+':
            firstNonWhiteSpace += 1
        
        val = 0
        while firstNonWhiteSpace < len(str) and str[firstNonWhiteSpace] in digit:
            d =  digit[str[firstNonWhiteSpace]]
            if sign == 1 and val * 10 - 2147483647 + d >= 0:
                return 2147483647
            elif sign == -1 and val * 10 - 2147483647 + d -1 >= 0:
                return -2147483648
            else:
                val = val * 10 + d
            firstNonWhiteSpace += 1
        return sign * val
            