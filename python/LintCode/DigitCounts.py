class Solution:
    # @param k & n  two integer
    # @return ans a integer
    def digitCounts(self, k, n):
        base = 1
        counts = 0
        while n/base > 0:
            higherBits = n / (base * 10)
            lowerBits = n % base
            curBit = (n / base) % 10
            if curBit == k:
                counts += higherBits * base + lowerBits + 1
            elif curBit < k:
                counts += higherBits * base
            else:
                counts += (higherBits + 1) * base
            base *= 10
        return counts