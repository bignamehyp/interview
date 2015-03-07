class Solution:
    """
    @param A: A positive integer which has N digits, A is a string.
    @param k: Remove k digits.
    @return: A string
    """
    def DeleteDigits(self, A, k):
        # write you code here
        if k == len(A):
            return "0"
        stack = []
        i = 0
        removed = set()
        A += '0'
        while i < len(A):
            if len(stack) == 0 or A[i] >= A[stack[-1]]:
                stack.append(i)
                i += 1
            else:
                if len(removed) < k:
                    removed.add(stack.pop())
                else:
                    break
        soln = []
        A = A[:-1]
        for i in range(len(A)):
            if i not in removed:
                soln.append(A[i])
        return ''.join(soln).strip('0')
                 