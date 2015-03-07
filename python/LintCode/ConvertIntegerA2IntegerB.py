class Solution:
    """
    @param a, b: Two integer
    return: An integer
    """
    def bitSwapRequired(self, a, b):
        # write your code here
        c = (a ^ b) & ( (2 ** 32) - 1)
        bits = 0
        while c > 0:
            bits += c % 2
            c = c/2
        return bits