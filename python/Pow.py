class Pow:
    def pow(self,x,n):
        if n < 0: 
            x = 1.0 / x
            n *= -1
        if n == 0:
            return 1

        if n%2 == 0:
            return self.pow(x*x, n/2)
        else:
            return x * self.pow(x,n-1)
