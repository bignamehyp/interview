class Int2Roman:
    def intToRoman(self, num):
        dict = ['I', 'V', 'X', 'L', 'C', 'D', 'M']
        level = 0
        soln = ""
        while num > 0:
            d = num % 10
            if 0 < d <= 3 or 5 < d < 9:
                while d != 0 and d != 5:
                    soln+= dict[level]
                    d -= 1
            if d == 4:
                soln += dict[level + 1] 
                soln += dict[level] 
            if d == 5:
                soln += dict[level + 1]
            if d == 9:
                soln += dict[level + 2] 
                soln += dict[level] 
            num = num / 10
            level += 2
        return soln[::-1]
                
            
                