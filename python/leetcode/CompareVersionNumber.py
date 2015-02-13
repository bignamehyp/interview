class Solution:
    # @param version1, a string
    # @param version2, a string
    # @return an integer
    def compareVersion(self, version1, version2):
        parts1 = version1.split('.')
        parts2 = version2.split('.')
        n1 = len(parts1)
        n2 = len(parts2)
        i1 = 0
        i2 = 0
        while i1 < n1 or i2 < n2:
            v1 = 0
            if i1 < n1:
                v1 = int(parts1[i1])
                i1 += 1
            v2 = 0
            if i2 < n2:
                v2 = int(parts2[i2])
                i2 += 1
            if v1 < v2:
                return -1
            elif v1 > v2:
                return 1
                
        return 0