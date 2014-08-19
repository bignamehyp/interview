class DecodeWays:
    def numDecodings(self, s):      
        if len(s) == 0:return 0
        part1 = 0
        part2 = 0
        total = 0
        if s[0] != '0': part1 = 1
        if(len(s) == 1):
            return part1
        if s[1] != '0': part2 += part1
         
        if 10 <= int(s[0:2]) <= 26: part2+=1
         
        if(len(s) == 2):return part2
         
        for pos in range(2, len(s)):
            total = 0
            if 10 <= int(s[pos-1:pos+1]) <= 26: total+=part1
            if(s[pos] != '0'):total+=part2
            part1 = part2
            part2 = total
        return total
        