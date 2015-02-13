class ReverseInteger:
    def reverse(self, x):
        if x == 0:
            return 0
        elif x < 0:
            return self.reverse(-x) * -1
        else:
            result = 0
            while x > 0:
                d = x % 10
                result = result * 10 + d
                x = x / 10
            return result
            