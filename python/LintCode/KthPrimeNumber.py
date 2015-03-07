class Solution:
    """
    @param k: The number k.
    @return: The kth prime number as description.
    """
    def kthPrimeNumber(self, k):
        # write your code here
        q = []
        i = 1
        q.append(1)
        i3, i5, i7 = 0, 0, 0
        while i <= k:
            val = min(q[i3] * 3, min(q[i5] * 5, q[i7] * 7))
            if val / q[i3] == 3:
                i3 += 1
            if val / q[i5] == 5:
                i5 += 1
            if val / q[i7] == 7:
                i7 += 1
            q.append(val)
            i += 1
        return q[-1]